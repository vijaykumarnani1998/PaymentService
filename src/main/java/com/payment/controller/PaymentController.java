package com.payment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.payment.dto.PaymentDto;
import com.payment.service.PaymentService;

@RestController
@RequestMapping("/payments")
public class PaymentController {
	 @Autowired
	 private PaymentService service;
	@PostMapping("/create")
 public PaymentDto savePayment(@RequestBody PaymentDto paymentDto)
 {
		return service.savePayment(paymentDto);
 }
}
