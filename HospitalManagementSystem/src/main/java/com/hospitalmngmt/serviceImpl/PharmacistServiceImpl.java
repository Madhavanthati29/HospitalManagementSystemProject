package com.hospitalmngmt.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hospitalmngmt.entity.Doctor;
import com.hospitalmngmt.entity.Pharmacist;
import com.hospitalmngmt.exception.ResourceNotFoundException;
import com.hospitalmngmt.repository.PharmacistRepository;
import com.hospitalmngmt.service.PharmacistService;

@Service
public class PharmacistServiceImpl implements PharmacistService
{
	@Autowired
	private PharmacistRepository pharmacistRepository;
	
	public PharmacistServiceImpl(PharmacistRepository pharmacistRepository) {
		super();
		this.pharmacistRepository = pharmacistRepository;
	}

	@Override
	public Pharmacist savePharmacist(Pharmacist pharmacist) {
		System.out.println("pharmacist register service" + pharmacist);

		return pharmacistRepository.save(pharmacist);
	}
	
	@Override
	public Pharmacist loginPharmacist(Pharmacist pharmacist) {
		return this.pharmacistRepository.findByPharmacistEmailIdAndPharmacistPassword(pharmacist.pharmacistEmailId, pharmacist.pharmacistPassword)
				.orElseThrow(() -> new ResourceNotFoundException("Pharmacist ", "Id",
						pharmacist.pharmacistEmailId + "and password " + pharmacist.pharmacistPassword));
	}
	
	public List<Pharmacist> getAllPharmacists() {
		return pharmacistRepository.findAll();
	}
	
	@Override
	public Pharmacist getPharmacistById(int pharmacistId) {
		return pharmacistRepository.findById(pharmacistId)
				.orElseThrow(() -> new ResourceNotFoundException("Pharmacist","Id",pharmacistId));
	}

	public Pharmacist addPharmacist(Pharmacist pharmacist) {
		return pharmacistRepository.save(pharmacist);
	}
	
	@Override
	public Pharmacist updatePharmacist(Pharmacist pharmacist, int pharmacistId) {
		Pharmacist existingPharmacist = pharmacistRepository.findById(pharmacistId)
				.orElseThrow(() -> new ResourceNotFoundException("Pharmacist","Id",pharmacistId));
		existingPharmacist.setFirstName(pharmacist.getFirstName());
		existingPharmacist.setLastName(pharmacist.getLastName());
		existingPharmacist.setPharmacistAge(pharmacist.getPharmacistAge());
		existingPharmacist.setPharmacistEmailId(pharmacist.getPharmacistEmailId());
		existingPharmacist.setPhoneNumber(pharmacist.getPhoneNumber());
		existingPharmacist.setPharmacistGender(pharmacist.getPharmacistGender());
		return pharmacistRepository.save(existingPharmacist);
	}
	
	@Override
	public void deletePharmacist(int pharmacistId) {
		pharmacistRepository.deleteById(pharmacistId);
	}
}
