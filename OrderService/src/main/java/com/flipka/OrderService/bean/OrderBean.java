package com.flipka.OrderService.bean;


import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderBean {
    private String orderId;
    private Map<String,Integer> product_Qty;
    private int totalPrice;
    private String paymentId;
    private boolean paymentStatus;
}
