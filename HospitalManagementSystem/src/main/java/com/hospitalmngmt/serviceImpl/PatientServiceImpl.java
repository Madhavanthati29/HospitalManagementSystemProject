package com.hospitalmngmt.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hospitalmngmt.entity.Patient;
import com.hospitalmngmt.exception.ResourceNotFoundException;
import com.hospitalmngmt.repository.PatientRepository;
import com.hospitalmngmt.service.PatientService;

@Service
public class PatientServiceImpl implements PatientService
{
	@Autowired
	private PatientRepository patientRepository;
	
	public PatientServiceImpl(PatientRepository patientRepository) {
		super();
		this.patientRepository = patientRepository;
	}

	@Override
	public Patient savePatient(Patient patient) {
		System.out.println("patient register service" + patient);

		return patientRepository.save(patient);
	}
	
	@Override
	public Patient updatePatient(Patient patient, int patientId) {
		Patient oldPatient =patientRepository.findById(patientId).orElseThrow(()->new ResourceNotFoundException("Patient ","PatientId",patientId));
		
		oldPatient.setFirstName(patient.getFirstName());
		oldPatient.setLastName(patient.getLastName());
		oldPatient.setPatientEmailId(patient.getPatientEmailId());
		oldPatient.setPatienttAge(patient.getPatienttAge());
		oldPatient.setBloodGroup(patient.getBloodGroup());
		oldPatient.setPhoneNumber(patient.getPhoneNumber());
		oldPatient.setPatientGender(patient.getPatientGender());
		
		patientRepository.save(oldPatient);
		
		return oldPatient;
	}

	public Patient getPatientById(int patientId) {
		 
		return patientRepository.findById(patientId).orElseThrow(()->new ResourceNotFoundException("Patient","PatientId",patientId));
	}
}
