package com.flipka.PaymentService.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.flipka.PaymentService.bean.PaymentBean;
import com.flipka.PaymentService.service.PaymentService;

@RestController
@RequestMapping("/payment")
public class PaymentController {
	@Autowired
	private PaymentService paymentService;

	@GetMapping("/paymentIntegration")
	public  PaymentBean paymentIntegration() {
		return paymentService.paymentIntegration();
	}

}
