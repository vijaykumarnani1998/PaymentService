package com.payment.stripe;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.payment.dto.PaymentDto;
import com.payment.entity.PaymentStatus;
import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.Charge;

import jakarta.annotation.PostConstruct;



@Service
public class StripePaymentGateway {
	
	//lombok Value will not work here
	@Value("${stripe.key}")
	private String secretKey;
	
	@PostConstruct
	public void init()
	{
		Stripe.apiKey=secretKey;
	}
	
	public void makePayment(PaymentDto paymentDto1) 
	{
		try {
		Map<String,Object> map= new HashMap<>();
		map.put("amount", paymentDto1.getPaymentAmount());
		map.put("currency", "inr");
		map.put("description", "Test Payment");
		map.put("source", "tok_visa");
	
		Charge.create(map);
		paymentDto1.setPaymentStatus(PaymentStatus.APPROVED);
	} catch (StripeException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}	
	}
	
	

}
