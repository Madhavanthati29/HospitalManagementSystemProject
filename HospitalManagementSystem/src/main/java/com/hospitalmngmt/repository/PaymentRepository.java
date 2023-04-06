package com.hospitalmngmt.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hospitalmngmt.entity.Payment;

public interface PaymentRepository extends JpaRepository<Payment,Integer>
{

}
