package com.hospitalmngmt.controller;

import java.text.ParseException;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.hospitalmngmt.entity.Appointment;
import com.hospitalmngmt.entity.Doctor;
import com.hospitalmngmt.entity.Patient;
import com.hospitalmngmt.entity.Prescription;
import com.hospitalmngmt.exception.IdMismatchException;
import com.hospitalmngmt.exception.PrescriptionNotValidException;
import com.hospitalmngmt.service.AppointmentService;
import com.hospitalmngmt.service.DoctorService;
import com.hospitalmngmt.service.PrescriptionService;

@RestController
@RequestMapping("/api/doctor")
public class DoctorController 
{
	@Autowired
	private DoctorService doctorService;
	
	@Autowired
	public PrescriptionService prescriptionService;
	
	@Autowired
	public AppointmentService appointmentService;

	@PostMapping("/register")
	public ResponseEntity<Doctor> saveAdmin(@Valid @RequestBody Doctor doctor){
		System.out.println("Doctor Registration Succesfull "+doctor);
		return new ResponseEntity<Doctor>(doctorService.saveDoctor(doctor),HttpStatus.CREATED);
	}

	@PostMapping("/login")
	public ResponseEntity<Doctor> loginDoctor(@RequestBody Doctor doctor) {
		return new ResponseEntity<Doctor>(doctorService.loginDoctor(doctor), HttpStatus.OK);

	}
	
	@PutMapping("{doctorId}")
	public ResponseEntity<Doctor> updateDoctor(@PathVariable("doctorId") int doctorId, @RequestBody Doctor doctor) {
	
		return new ResponseEntity<Doctor>(doctorService.updateDoctor(doctor,doctorId),HttpStatus.OK);
	}
	
	@GetMapping("/booking")
	public List<Appointment> getAllAppointments(){
		
		return appointmentService.getAllAppointments() ;
	}
	
	@PostMapping("/register/prescription/{appointmentId}")
	public ResponseEntity<Prescription> generatePrescription(@Valid @RequestBody Prescription prescription,@PathVariable("appointmentId") long appointmentId) throws ParseException, IdMismatchException, PrescriptionNotValidException{
		 	return new ResponseEntity<Prescription>(prescriptionService.generatePrescription(prescription,appointmentId),HttpStatus.CREATED);
	}
	
	@GetMapping("patient/{doctorId}")
	public List<Patient> getAllPatientsByDoctorId(@PathVariable("doctorId") int doctorId){
		
		return doctorService.getAllPatientsByDoctorId(doctorId);
	}
}
