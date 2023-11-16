package com.payment.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.payment.dto.PaymentDto;
import com.payment.entity.PaymentEntity;
import com.payment.entity.PaymentStatus;
import com.payment.repository.PaymentRepository;
import com.payment.service.PaymentService;
import com.payment.stripe.StripePaymentGateway;

@Service
public class PaymentServiceImpl implements PaymentService {

	@Autowired
	private  PaymentRepository repo;
	
	@Autowired
	private StripePaymentGateway stripePaymentGateway;
	@Override
	public PaymentDto savePayment(PaymentDto paymentDto) {
		
		PaymentEntity paymentEntity = PaymentEntity.builder()
		             .bookingId(paymentDto.getBookingId())
		             .paymentAmount(paymentDto.getPaymentAmount())
		             .paymentStatus(PaymentStatus.PENDING)
		             .paymentTime(paymentDto.getPaymentTime())
		            .build();
		repo.save(paymentEntity);
		
		//Building  paymentDto before it is taken by Stripe().Because Stripe method used PaymentDto
		PaymentDto paymentDto1 = PaymentDto.builder()
		          .paymentId(paymentEntity.getPaymentId())
		          .bookingId(paymentEntity.getBookingId())
		          .paymentStatus(PaymentStatus.PENDING)
		           .paymentTime(paymentEntity.getPaymentTime())
		          .paymentAmount(paymentEntity.getPaymentAmount())
		          .build();
		
		stripePaymentGateway.makePayment(paymentDto1);
		
		if(paymentDto1.getPaymentStatus().equals(PaymentStatus.APPROVED))
		{
			paymentEntity.setPaymentStatus(PaymentStatus.APPROVED);
			repo.save(paymentEntity);  //Alternative is  @Transactional
		}
		else
		{
			paymentEntity.setPaymentStatus(PaymentStatus.CANCELLED);
			repo.save(paymentEntity); //Alternative is  @Transactional
			paymentDto1.setPaymentStatus(PaymentStatus.CANCELLED);
		}
		
	
		
		return paymentDto1;
		
	
	 
	}
	
	

}
