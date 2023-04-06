package com.hospitalmngmt.serviceImpl;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hospitalmngmt.entity.Appointment;
import com.hospitalmngmt.entity.Doctor;
import com.hospitalmngmt.entity.Patient;
import com.hospitalmngmt.exception.AppointmentNotValidException;
import com.hospitalmngmt.exception.ResourceNotFoundException;
import com.hospitalmngmt.repository.AppointmentRepository;
import com.hospitalmngmt.repository.PatientRepository;
import com.hospitalmngmt.service.AppointmentService;
import com.hospitalmngmt.service.DoctorService;
import com.hospitalmngmt.service.PatientService;

@Service
public class AppointmentServiceImpl implements AppointmentService
{
	@Autowired
	public AppointmentRepository appointmentRepository;
	
	@Autowired
	public PatientRepository patientRepository;
	
	@Autowired
	public DoctorService doctorService;
	
	@Autowired
	public PatientService patientService;
	
	@Override
	public Appointment addAppointment(int doctorId,int patientId,Appointment appointment) throws AppointmentNotValidException {
	
		List<Appointment> appointments = appointmentRepository.findBookingAppointmentByPatientId(patientId);
		
		for(Appointment appointment2:appointments) {
			Doctor doctor = appointment.getDoctor();
			if(appointment2.getAppointmentDate().equals(appointment.getAppointmentDate())) {
				if(appointment2.getAppointmentTime()==appointment.getAppointmentTime()) {
					if(appointment2.getMeridiem().equals(appointment.getMeridiem())) {
						if(doctor.getDoctorId()==doctorId) {
						throw new AppointmentNotValidException("you cant take appointment with this doctor same time");
				
						}
					}
				}
			}
		}
		
		Doctor doctor = doctorService.getDoctorById(doctorId) ;
		
		Patient patient = patientService.getPatientById(patientId);
		
		patient.setDoctorId(doctor.getDoctorId());
		
		patientRepository.save(patient);
		
		appointment.setPatientId(patient.getPatientId());
		 
		
		
		appointment.setDoctor(doctor);
//		System.out.println("doctor"+doctor);
//		System.out.println("bookingappointment"+bookingAppointment);
		
		return appointmentRepository.save(appointment);
	
}
	@Override
	public List<Appointment> getAllAppointments() {

		return appointmentRepository.findAll();
	}
	@Override
	public Appointment getAppointmentById(long appointmentId) {
		 
		return appointmentRepository.findById(appointmentId).orElseThrow(()->new ResourceNotFoundException("Appointment","Appointment Id",appointmentId));
		
	}
}
