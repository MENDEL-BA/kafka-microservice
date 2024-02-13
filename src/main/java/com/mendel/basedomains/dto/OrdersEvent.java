package com.mendel.basedomains.dto;

import com.mendel.basedomains.domains.Orders;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrdersEvent {
    private String message;
    private String status;
    private Orders order;
}