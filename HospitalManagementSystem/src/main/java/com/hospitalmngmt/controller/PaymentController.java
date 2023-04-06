package com.hospitalmngmt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hospitalmngmt.entity.Payment;
import com.hospitalmngmt.service.PaymentService;

@RestController
@RequestMapping("/api/payment")
public class PaymentController 
{
	@Autowired 
	private PaymentService paymentService; 
	
	@PostMapping("/register/{patientId}/{prescriptionId}/{pharmacistId}")
	public ResponseEntity<Payment> addPayment(@RequestBody Payment payment,@PathVariable("patientId") int patientId,
		 @PathVariable("prescriptionId") int prescriptionId, @PathVariable("pharmacistId") int pharmacistId) throws Exception {

		return new ResponseEntity<Payment>(paymentService.addPayment(payment, patientId, prescriptionId, pharmacistId),HttpStatus.CREATED);
	}
	
	@GetMapping
	public List<Payment> getAllPayments(){
		return paymentService.getAllPayments();
	}
	
	@GetMapping("{paymentId}")
	public ResponseEntity<Payment> getPaymentById(@PathVariable("paymentId") int paymentId){
		
		return new ResponseEntity<Payment>(paymentService.getPaymentById(paymentId),HttpStatus.OK);
	}
}
