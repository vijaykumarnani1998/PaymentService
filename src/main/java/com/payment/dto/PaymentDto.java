package com.payment.dto;

import java.time.LocalDateTime;



import com.payment.entity.PaymentStatus;


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
	//@CreationTimestamp  // Optional
	private LocalDateTime paymentTime;
//	@Enumerated(EnumType.STRING) //Optional
	private PaymentStatus paymentStatus;
}
