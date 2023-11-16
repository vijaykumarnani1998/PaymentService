package com.payment.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.payment.entity.PaymentEntity;

public interface PaymentRepository extends JpaRepository<PaymentEntity, String>{

}
