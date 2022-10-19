package com.flipka.OrderService.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "ORDER_DB")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderEntity {
	@Id
	private String orderId;
	@ElementCollection
	@CollectionTable(name = "order_product_mapping", joinColumns = {
			@JoinColumn(name = "orderId", referencedColumnName = "orderId") })
	@MapKeyColumn(name = "product_name")
	@Column(name = "qty")
	private Map<String, Integer> product_Qty;
	private int totalPrice;
	private String paymentId;
	private boolean paymentStatus;
}
