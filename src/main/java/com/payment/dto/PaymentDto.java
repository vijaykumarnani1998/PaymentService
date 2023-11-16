package com.payment.dto;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import com.payment.entity.PaymentStatus;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PaymentDto {
	private Integer paymentId;
	private  Integer bookingId;
	private  Integer paymentAmount;
	@CreationTimestamp
	private LocalDateTime paymentTime;
	@Enumerated(EnumType.STRING)
	private PaymentStatus paymentStatus;
}
