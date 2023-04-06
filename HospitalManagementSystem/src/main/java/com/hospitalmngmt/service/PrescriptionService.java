package com.hospitalmngmt.service;

import java.text.ParseException;
import java.util.List;

import com.hospitalmngmt.entity.Prescription;
import com.hospitalmngmt.exception.IdMismatchException;
import com.hospitalmngmt.exception.PrescriptionNotValidException;

public interface PrescriptionService {
	List<Prescription> getAllPrescriptions();
//	Prescription getPrescriptionById(int prescriptionId);
	void deletePrescription(int prescriptionId);
	Prescription generatePrescription(Prescription prescription, long appointmentId)
			throws ParseException, IdMismatchException, PrescriptionNotValidException;
	Prescription getPrescriptionById(int prescriptionId);

}
