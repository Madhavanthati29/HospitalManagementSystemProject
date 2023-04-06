package com.hospitalmngmt.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hospitalmngmt.entity.Patient;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Integer> 
{

	Optional<Patient> findById(int patientId);

	List<Patient> findPatientByDoctorId(int doctorId);
	
}
