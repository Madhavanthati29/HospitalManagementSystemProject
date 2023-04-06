package com.hospitalmngmt.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.hospitalmngmt.entity.Pharmacist;

@Repository
public interface PharmacistRepository extends JpaRepository<Pharmacist, Integer>
{
	Optional<Pharmacist> findByPharmacistEmailIdAndPharmacistPassword(String pharmacistEmailId,String pharmacistPassword);
}
