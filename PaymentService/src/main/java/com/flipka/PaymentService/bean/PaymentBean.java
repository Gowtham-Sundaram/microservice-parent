package com.flipka.PaymentService.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PaymentBean {
	private String paymentId;
	private boolean paymentStatus;
}
