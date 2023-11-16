package com.payment.entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Data;

@Data
@Entity
@Table(name="Payments")
@Builder
public class PaymentEntity {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer paymentId;
	private  Integer bookingId;
	private  Integer paymentAmount;
	@CreationTimestamp
	private LocalDateTime paymentTime;
	@Enumerated(EnumType.STRING)
	private PaymentStatus paymentStatus;
}
