package com.hospitalmngmt.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hospitalmngmt.entity.Patient;
import com.hospitalmngmt.service.PatientService;

@RestController
@RequestMapping("/api/patient")
public class PatientController 
{
	@Autowired
	private PatientService patientService;
	
	public PatientController(PatientService patientService) {
		super();
		this.patientService = patientService;
	}

	@PostMapping("/register")
	public ResponseEntity<Patient> saveAdmin(@Valid @RequestBody Patient patient){
		System.out.println("Patient Registration Succesfull "+patient);
		return new ResponseEntity<Patient>(patientService.savePatient(patient),HttpStatus.CREATED);
	}
	
	@PutMapping("{patientId}")
	public ResponseEntity<Patient> updatePatient(@PathVariable("patientId") int patientId, @RequestBody Patient patient) {
	
		return new ResponseEntity<Patient>(patientService.updatePatient(patient,patientId),HttpStatus.OK);
	}
	
	@GetMapping("{patientId}")
	public ResponseEntity<Patient> getPatientById(@PathVariable("patientId") int patientId){
		
		return new ResponseEntity<Patient>(patientService.getPatientById(patientId),HttpStatus.OK);
	}
	
}
   




