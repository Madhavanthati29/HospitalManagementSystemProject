package com.hospitalmngmt.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hospitalmngmt.entity.Doctor;
import com.hospitalmngmt.entity.Patient;
import com.hospitalmngmt.exception.ResourceNotFoundException;
import com.hospitalmngmt.repository.DoctorRepository;
import com.hospitalmngmt.repository.PatientRepository;
import com.hospitalmngmt.service.DoctorService;

@Service
public class DoctorServiceImpl implements DoctorService
{
	@Autowired
	private DoctorRepository doctorRepository;
	
	@Autowired
	public PatientRepository patientRepository;
	
	public DoctorServiceImpl(DoctorRepository doctorRepository) {
		super();
		this.doctorRepository = doctorRepository;
	}

	@Override
	public Doctor saveDoctor(Doctor doctor) {
		System.out.println("doctor register service" + doctor);

		return doctorRepository.save(doctor);
	}
	
	@Override
	public Doctor loginDoctor(Doctor doctor) {
		return this.doctorRepository.findByDoctorEmailIdAndDoctorPassword(doctor.doctorEmailId, doctor.doctorPassword)
				.orElseThrow(() -> new ResourceNotFoundException("Doctor ", "Id",
						doctor.doctorEmailId + "and password " + doctor.doctorPassword));
	}
	
	public List<Doctor> getAllDoctors() {
		return doctorRepository.findAll();
	}
	
	@Override
	public Doctor getDoctorById(int doctorId) {
		return doctorRepository.findById(doctorId)
				.orElseThrow(() -> new ResourceNotFoundException("Doctor","DoctorId",doctorId));
	}

	public Doctor addDoctor(Doctor doctor) {
		return doctorRepository.save(doctor);
	}
	
	@Override
	public Doctor updateDoctor(Doctor doctor, int doctorId) {
		Doctor existingDoctor = doctorRepository.findById(doctorId).orElseThrow(() -> new ResourceNotFoundException("Doctor","DoctorId",doctorId));
		existingDoctor.setFirstName(doctor.getFirstName());
		existingDoctor.setLastName(doctor.getLastName());
		existingDoctor.setDoctorEmailId(doctor.getDoctorEmailId());
		existingDoctor.setDoctorAge(doctor.getDoctorAge());
		existingDoctor.setDoctorSpecialist(doctor.getDoctorSpecialist());
		existingDoctor.setPhoneNumber(doctor.getPhoneNumber());
		existingDoctor.setDoctorGender(doctor.getDoctorGender());
		existingDoctor.setDoctorPassword(doctor.getDoctorPassword());
		return doctorRepository.save(existingDoctor);
	}
	
	@Override
	public void deleteDoctor(int doctorId) {
		doctorRepository.findById(doctorId).orElseThrow(()->new ResourceNotFoundException("Doctor","DoctorId",doctorId));
		doctorRepository.deleteById(doctorId);
		
	}

	@Override
	public List<Patient> getAllPatientsByDoctorId(int doctorId) {
		// TODO Auto-generated method stub
		return patientRepository.findPatientByDoctorId(doctorId);
	}
}
