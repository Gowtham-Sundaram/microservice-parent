package com.flipka.OrderService.service;

import com.flipka.OrderService.bean.OrderBean;
import com.flipka.OrderService.bean.PaymentBean;
import com.flipka.OrderService.common.Product_Order;
import com.flipka.OrderService.entity.OrderEntity;
import com.flipka.OrderService.entity.ProductEntity;
import com.flipka.OrderService.repository.OrderRepository;

import lombok.AllArgsConstructor;
import reactor.core.publisher.Mono;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.*;

@Service
public class OrderService {

	@Autowired
	private OrderRepository orderRepository;

	@Autowired
	private WebClient webClient;

	/*
	 * public ProductEntity test() { final String productUrl =
	 * "http://ProductService/product/get/"; return
	 * webClient.get().uri(String.join(productUrl,
	 * "1")).retrieve().bodyToMono(ProductEntity.class).block(); }
	 */

	// restTemplate.getForEntity(productUrl + po.getProductId(),
	// ProductEntity.class).getBody()

	public OrderEntity saveOrder(List<Product_Order> product_order_list) {

		OrderBean orderBean = new OrderBean();

		Map<ProductEntity, Integer> product_Qty = new LinkedHashMap<>();
		final String productUrl = "http://localhost:8989/product/get/";
		product_order_list.stream()
				.forEach(po -> product_Qty
						.put(webClient.get().uri(String.join("", productUrl, String.valueOf(po.getProductId())))
								.retrieve().bodyToMono(ProductEntity.class).block(), po.getQuantity()));
		orderBean.setOrderId(UUID.randomUUID().toString());
		Map<String, Integer> productName_Qty1 = new LinkedHashMap<>();
		product_Qty.entrySet().stream().forEach(i -> productName_Qty1.put(i.getKey().getProductName(), i.getValue()));

		orderBean.setProduct_Qty(productName_Qty1);
		int totalPrice = product_Qty.entrySet().stream()
				.map(productEntityIntegerEntry -> (productEntityIntegerEntry.getKey().getPrice()
						* productEntityIntegerEntry.getValue()))
				.reduce(0, Integer::sum);
		orderBean.setTotalPrice(totalPrice);
		final String paymentUrl = "http://localhost:8989/payment/paymentIntegration";
		PaymentBean paymentBean = webClient.get().uri(paymentUrl).retrieve().bodyToMono(PaymentBean.class).block();

		orderBean.setPaymentId(paymentBean.getPaymentId());
		orderBean.setPaymentStatus(paymentBean.isPaymentStatus());
		OrderEntity orderEntity = new OrderEntity();
		BeanUtils.copyProperties(orderBean, orderEntity);

		return orderRepository.save(orderEntity);
	}

	public OrderEntity getOrderById(String orderId) {
		return orderRepository.findById(orderId).get();
	}

}
