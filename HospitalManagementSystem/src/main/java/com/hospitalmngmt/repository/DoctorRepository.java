package com.hospitalmngmt.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.hospitalmngmt.entity.Doctor;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Integer>
{
	Optional<Doctor> findByDoctorEmailIdAndDoctorPassword(String doctorEmailId,String doctorPassword);
}
