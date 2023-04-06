package com.hospitalmngmt.controller;

import java.util.List;

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

import com.hospitalmngmt.entity.Admin;
import com.hospitalmngmt.entity.Doctor;
import com.hospitalmngmt.entity.Pharmacist;
import com.hospitalmngmt.service.AdminService;
import com.hospitalmngmt.service.DoctorService;
import com.hospitalmngmt.service.PharmacistService;

@RestController
@RequestMapping("/api/admin")
public class AdminController 
{
	@Autowired
	private AdminService adminService;
	
	@Autowired
	private DoctorService doctorService;
	
	@Autowired
	private PharmacistService pharmacistService;
	
	@PostMapping("/register")
	public ResponseEntity<com.hospitalmngmt.entity.Admin> saveAdmin(@Valid @RequestBody Admin admin) {
		System.out.println("admin register " + admin);
		return new ResponseEntity<Admin>(adminService.saveAdmin(admin), HttpStatus.CREATED);
	}

	@PostMapping("/login")
	public ResponseEntity<Admin> loginAdmin(@RequestBody Admin admin) {
		return new ResponseEntity<Admin>(adminService.loginAdmin(admin), HttpStatus.OK);

	}
	
	@GetMapping
	public List<Admin> getAllAdmins(){
		return adminService.getAllAdmins();
	}
	//get admin by id
	@GetMapping("{adminId}")
	public ResponseEntity<Admin> getAdminById(@PathVariable("adminId") int adminId){
		
		return new ResponseEntity<Admin>(adminService.getAdminById(adminId),HttpStatus.OK);
	}
	
	//updating admin details
	@PutMapping("{adminId}")
	public ResponseEntity<Admin> updateAdmin(@PathVariable("adminId") int adminId, @RequestBody Admin admin) {
	
		return new ResponseEntity<Admin>(adminService.updateAdmin(admin,adminId),HttpStatus.OK);
	}
	//delete by id
	@DeleteMapping("{adminId}")
	public ResponseEntity<Boolean> deleteAdmin(@PathVariable("adminId") int adminId){
		adminService.deleteAdmin(adminId);
		boolean flag = true;
		return new ResponseEntity<Boolean>(flag, HttpStatus.OK);
		
	}
	
	@PostMapping("/register/doctor")
	public ResponseEntity<Doctor> saveDoctor(@Valid @RequestBody Doctor doctor){
		System.out.println("Doctor Registration Succesfull "+doctor);
		return new ResponseEntity<Doctor>(doctorService.saveDoctor(doctor),HttpStatus.CREATED);
	}
	
		//get all doctor details
		@GetMapping("/doctor")
		public List<Doctor> getAllDoctors(){
			return doctorService.getAllDoctors();
		}
		
		//get doctor by id
		@GetMapping("/doctor/{doctorId}")
		public ResponseEntity<Doctor> getDoctorById(@PathVariable("doctorId") int doctorId){
			
			return new ResponseEntity<Doctor>(doctorService.getDoctorById(doctorId),HttpStatus.OK);
		}
		//updating doctor details
		@PutMapping("/doctor/{doctorId}")
		public ResponseEntity<Doctor> updateDoctor(@PathVariable("doctorId") int doctorId, @RequestBody Doctor doctor) {
		
			return new ResponseEntity<Doctor>(doctorService.updateDoctor(doctor,doctorId),HttpStatus.OK);
		}
		//delete by id
		@DeleteMapping("/doctor/{doctorId}")
		public ResponseEntity<Boolean> deleteDoctor(@PathVariable("doctorId") int doctorId){
			doctorService.deleteDoctor(doctorId);
			boolean flag = true;
			return new ResponseEntity<Boolean>(flag, HttpStatus.OK);
			
		}
		
		@PostMapping("/register/pharmacist")
		public ResponseEntity<Pharmacist> savePharmacist(@Valid @RequestBody Pharmacist pharmacist) {
			System.out.println("admin register " + pharmacist);
			return new ResponseEntity<Pharmacist>(pharmacistService.savePharmacist(pharmacist), HttpStatus.CREATED);
		}
		
		@PostMapping("/add Pharmacists")
		public ResponseEntity<Pharmacist> addPharmacist(@Valid @RequestBody Pharmacist pharmacist ) {

			return new ResponseEntity<Pharmacist>(pharmacistService.addPharmacist(pharmacist), HttpStatus.CREATED);
		}

		@GetMapping("/pharmacist")
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
