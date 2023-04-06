package com.hospitalmngmt.serviceImpl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hospitalmngmt.entity.Patient;
import com.hospitalmngmt.entity.Payment;
import com.hospitalmngmt.entity.Pharmacist;
import com.hospitalmngmt.entity.Prescription;
import com.hospitalmngmt.exception.ResourceNotFoundException;
import com.hospitalmngmt.repository.PatientRepository;
import com.hospitalmngmt.repository.PaymentRepository;
import com.hospitalmngmt.service.PatientService;
import com.hospitalmngmt.service.PaymentService;
import com.hospitalmngmt.service.PharmacistService;
import com.hospitalmngmt.service.PrescriptionService;

@Service
public class PaymentServiceImpl implements PaymentService {
	@Autowired
	private PaymentRepository paymentRepository;

	@Autowired
	private PatientRepository patientRepository;

	@Autowired
	private PatientService patientService;

	@Autowired
	private PrescriptionService prescriptionService;

	@Autowired
	private PharmacistService pharmacistService;

	@Override
	public Payment addPayment(Payment payment, int patientId, int prescriptionId, int pharmacistId) throws Exception {
		Prescription gettingPrescription = prescriptionService.getPrescriptionById(prescriptionId);

		Patient patient = patientService.getPatientById(patientId);

		Pharmacist pharmacist = pharmacistService.getPharmacistById(pharmacistId);

		String status = gettingPrescription.getStatus();

		if (status.equals("admit")) 
		{
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

			java.util.Date date = new Date();
			// date.getHours();
			System.out.println();
			// System.out.println(date.getHours());
			String currentDate = sdf.format(date);
			System.out.println();
			System.out.println(currentDate);

			payment.setPaymentDate(date);

			payment.setPrescriptionId(gettingPrescription.getPrescriptionId());

			List<Payment> existingPayment = paymentRepository.findAll();

			patientRepository.save(patient);
		} 
		else 
		{
			payment.setPrescriptionId(gettingPrescription.getPrescriptionId());

			payment.setTotalPayment(300);

			payment.setPatient(patient);

//			patient.setPaymentStatus(payment.getPaymentStatus());

			payment.setPaymentDate(new Date());
			patientRepository.save(patient);
		}

		return paymentRepository.save(payment);
	}

	@Override
	public List<Payment> getAllPayments() {
		return paymentRepository.findAll();
	}

	@Override
	public Payment getPaymentById(int paymentId) {
		return paymentRepository.findById(paymentId).orElseThrow(()-> new ResourceNotFoundException("PaymentDetails","PaymentId",paymentId));
	}

}
