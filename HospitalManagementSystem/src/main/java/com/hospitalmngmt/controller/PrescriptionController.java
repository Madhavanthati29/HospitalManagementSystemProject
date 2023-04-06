package com.hospitalmngmt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hospitalmngmt.entity.Pharmacist;
import com.hospitalmngmt.entity.Prescription;
import com.hospitalmngmt.service.PrescriptionService;

@RestController
@RequestMapping("/api/prescription")
public class PrescriptionController {
	@Autowired
	private PrescriptionService prescriptionService;

	@DeleteMapping("{prescriptionId}")
	public ResponseEntity<Boolean> deletePrescription(@PathVariable("prescriptionId") int prescriptionId) {
		prescriptionService.deletePrescription(prescriptionId);
		boolean flag = true;
		return new ResponseEntity<Boolean>(flag, HttpStatus.OK);

	}
	
	@GetMapping("/prescription")
	public List<Prescription> getAllPrescriptions(){
		
		return prescriptionService.getAllPrescriptions() ;
	}
	
	@GetMapping("prescription/{prescriptionId}")
	public ResponseEntity<Prescription> getPrescriptionById(@PathVariable("prescriptionId") int prescriptionId) {
		return new ResponseEntity<Prescription>(prescriptionService.getPrescriptionById(prescriptionId), HttpStatus.OK);
	}
}
