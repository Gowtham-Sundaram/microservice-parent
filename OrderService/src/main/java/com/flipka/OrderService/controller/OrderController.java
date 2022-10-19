package com.flipka.OrderService.controller;

import com.flipka.OrderService.common.Product_Order;
import com.flipka.OrderService.entity.OrderEntity;
import com.flipka.OrderService.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {

	@Autowired
	private OrderService orderService;
            
	@PostMapping("/createOrder")
	public OrderEntity saveOrder(@RequestBody List<Product_Order> product_order_list) {
		return orderService.saveOrder(product_order_list);
	}

	@GetMapping("/get/{orderId}")
	public OrderEntity getOrderById(@PathVariable("orderId") String orderId) {
		return orderService.getOrderById(orderId);
	}

	

}
