package com.hospitalmngmt.controller;

import java.util.List;

import javax.persistence.SequenceGenerator;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hospitalmngmt.entity.Pharmacist;
import com.hospitalmngmt.service.PharmacistService;

@RestController
@RequestMapping("/api/pharmacist")
@SequenceGenerator(name="pharmacist",sequenceName="pharmacist_gene",initialValue=7000)
public class PharmacistController 
{
	@Autowired
	private PharmacistService pharmacistService;
	
	public PharmacistController(PharmacistService pharmacistService) {
		super();
		this.pharmacistService = pharmacistService;
	}

	@PostMapping("/register")
	public ResponseEntity<com.hospitalmngmt.entity.Pharmacist> savePharmacist(@Valid @RequestBody Pharmacist pharmacist) {
		System.out.println("admin register " + pharmacist);
		return new ResponseEntity<Pharmacist>(pharmacistService.savePharmacist(pharmacist), HttpStatus.CREATED);
	}

	@PostMapping("/login")
	public ResponseEntity<Pharmacist> loginPharmacist(@RequestBody Pharmacist pharmacist) {
		return new ResponseEntity<Pharmacist>(pharmacistService.loginPharmacist(pharmacist), HttpStatus.OK);

	}
	
	@PostMapping("/add Pharmacists")
	public ResponseEntity<Pharmacist> addPharmacist(@Valid @RequestBody Pharmacist pharmacist ) {

		return new ResponseEntity<Pharmacist>(pharmacistService.addPharmacist(pharmacist), HttpStatus.CREATED);
	}

	@GetMapping
	public List<Pharmacist> getAllPharmacists() {
		return pharmacistService.getAllPharmacists();
	}

	@GetMapping("Pharmacist/{pharmacistId}")
	public ResponseEntity<Pharmacist> getPharmacistById(@PathVariable("pharmacistId") int pharmacistId) {
		return new ResponseEntity<Pharmacist>(pharmacistService.getPharmacistById(pharmacistId), HttpStatus.OK);
	}

	@PutMapping("{pharmacistId}")
	public ResponseEntity<Pharmacist> updatePharmacist(@Valid @PathVariable("pharmacistId") int pharmacistId, @RequestBody Pharmacist pharmacist) {
		return new ResponseEntity<Pharmacist>(pharmacistService.updatePharmacist(pharmacist, pharmacistId), HttpStatus.OK);
	}

	@DeleteMapping("{pharmacistId}")
	public ResponseEntity<Boolean> deletePharmacist(@PathVariable("pharmacistId") int pharmacistId) {
		pharmacistService.deletePharmacist(pharmacistId);
		boolean flag = true;
		return new ResponseEntity<Boolean>(flag, HttpStatus.OK);
	}
}
