package com.hospitalmngmt.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hospitalmngmt.entity.Prescription;

public interface PrescriptionRepository extends JpaRepository<Prescription, Integer>
{

}
