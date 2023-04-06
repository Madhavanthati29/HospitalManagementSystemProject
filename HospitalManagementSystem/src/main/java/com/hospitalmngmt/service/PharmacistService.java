package com.hospitalmngmt.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.hospitalmngmt.entity.Pharmacist;

@Service
public interface PharmacistService 
{

	Pharmacist savePharmacist(Pharmacist pharmacist);
	Pharmacist loginPharmacist(Pharmacist pharmacist);
	List<Pharmacist> getAllPharmacists();
	Pharmacist addPharmacist(Pharmacist pharmacist);
	Pharmacist getPharmacistById(int pharmacistId);
	Pharmacist updatePharmacist(Pharmacist pharmacist, int pharmacistId);
	void deletePharmacist(int pharmacistId);

}
