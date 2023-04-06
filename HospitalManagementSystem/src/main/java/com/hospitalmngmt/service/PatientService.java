package com.hospitalmngmt.service;

import org.springframework.stereotype.Service;

import com.hospitalmngmt.entity.Patient;

@Service
public interface PatientService 
{

	Patient savePatient(Patient patient);

	Patient updatePatient(Patient patient, int patientId);

	Patient getPatientById(int patientId);

}
