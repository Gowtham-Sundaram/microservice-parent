 package com.flipka.PaymentService.service;

import java.util.Random;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.flipka.PaymentService.bean.PaymentBean;

@Service
public class PaymentService {

	public PaymentBean paymentIntegration() {
		PaymentBean paymentBean = new PaymentBean();
		paymentBean.setPaymentId(UUID.randomUUID().toString());
		paymentBean.setPaymentStatus(new Random().nextBoolean());
		return paymentBean;
	}

}
