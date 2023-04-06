package com.hospitalmngmt.service;

import java.util.List;

import com.hospitalmngmt.entity.Payment;

public interface PaymentService {

	
	Payment addPayment(Payment payment, int patientId, int prescriptionId, int pharmacistId) throws Exception;

	List<Payment> getAllPayments();

	Payment getPaymentById(int paymentId);


}
