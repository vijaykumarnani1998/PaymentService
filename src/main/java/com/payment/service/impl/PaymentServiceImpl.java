package com.payment.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.payment.dto.PaymentDto;
import com.payment.entity.PaymentEntity;
import com.payment.entity.PaymentStatus;
import com.payment.repository.PaymentRepository;
import com.payment.service.PaymentService;

@Service
public class PaymentServiceImpl implements PaymentService {

	@Autowired
	private  PaymentRepository repo;
	@Override
	public PaymentDto savePayment(PaymentDto paymentDto) {
		
		PaymentEntity entity = PaymentEntity.builder()
		             .bookingId(paymentDto.getBookingId())
		             .paymentAmount(paymentDto.getPaymentAmount())
		             .paymentStatus(PaymentStatus.PENDING)
		            .build();
		repo.save(entity);
		PaymentDto paymentDto1 = PaymentDto.builder()
		          .paymentId(entity.getPaymentId())
		          .bookingId(entity.getBookingId())
		          .paymentStatus(PaymentStatus.APPROVED)
		          .paymentTime(entity.getPaymentTime())
		          .paymentAmount(entity.getPaymentAmount())
		          .build();
		
		return paymentDto1;
		
	
	 
	}
	
	

}
