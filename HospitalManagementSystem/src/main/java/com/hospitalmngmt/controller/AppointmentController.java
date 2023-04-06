package com.hospitalmngmt.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hospitalmngmt.entity.Appointment;
import com.hospitalmngmt.exception.AppointmentNotValidException;
import com.hospitalmngmt.service.AppointmentService;

@RestController
//http://localhost:8088/api/booking
@RequestMapping("/api/booking/appointment")
public class AppointmentController 
{
	@Autowired
	private AppointmentService appointmentService;
	
	@PostMapping("/register/{doctorId}/{patientId}")
	public ResponseEntity<Appointment> addAppointment(@PathVariable("doctorId") int doctorId,@PathVariable("patientId") int patientId, @Valid @RequestBody Appointment appointment) throws AppointmentNotValidException{
		System.out.println("appointment Succesfull "+ appointment);
		return new ResponseEntity<Appointment>(appointmentService.addAppointment(doctorId,patientId,appointment),HttpStatus.CREATED);
	}
	
	@GetMapping
	public List<Appointment> getAllAppointments(){
		
		return appointmentService.getAllAppointments();
	}
	
	@GetMapping("{appointmentId}")
	public ResponseEntity<Appointment> getAppointmentById(@PathVariable("appointmentId") long appointmentId){
		
		return new ResponseEntity<Appointment>(appointmentService.getAppointmentById(appointmentId),HttpStatus.OK);
	}
}
