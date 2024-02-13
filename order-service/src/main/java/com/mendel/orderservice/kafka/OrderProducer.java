package com.mendel.orderservice.kafka;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.messaging.Message;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import com.mendel.basedomains.dto.OrdersEvent;

@Service
public class OrderProducer {

    private static final Logger LOGGER = LoggerFactory.getLogger(OrderProducer.class);

    private NewTopic topic;

    private KafkaTemplate<String, OrdersEvent> kafkaTemplate;

    public OrderProducer(NewTopic topic, KafkaTemplate<String, OrdersEvent> kafkaTemplate){
        this.topic = topic;
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(OrdersEvent ordersEvent){
        LOGGER.info(String.format("Order event => %s ", ordersEvent.toString()));

        Message<OrdersEvent> message = MessageBuilder
                            .withPayload(ordersEvent)
                            .setHeader(KafkaHeaders.TOPIC, topic.name())
                            .build();
        
        // Send the message to the Kafka broker via template
        kafkaTemplate.send(message);
    }

}
