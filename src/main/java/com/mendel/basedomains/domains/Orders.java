package com.mendel.basedomains.domains;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Orders {
    private String orderId;
    private String name;
    private int qty;
    private double price;
}