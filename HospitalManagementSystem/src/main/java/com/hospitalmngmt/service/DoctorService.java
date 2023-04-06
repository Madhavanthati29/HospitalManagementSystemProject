package com.hospitalmngmt.service;

import java.util.List;

import javax.validation.Valid;

import com.hospitalmngmt.entity.Doctor;
import com.hospitalmngmt.entity.Patient;

public interface DoctorService 
{
	Doctor saveDoctor(Doctor doctor);
	Doctor loginDoctor(Doctor doctor);
	List<Doctor> getAllDoctors();
	Doctor addDoctor(Doctor doctor);
	Doctor updateDoctor(Doctor doctor, @Valid int doctorId);
	void deleteDoctor(int doctorId);
	List<Patient> getAllPatientsByDoctorId(int doctorId);
	Doctor getDoctorById(int doctorId);
	
}
