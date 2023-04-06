package com.hospitalmngmt.serviceImpl;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hospitalmngmt.entity.Admin;
import com.hospitalmngmt.exception.ResourceNotFoundException;
import com.hospitalmngmt.repository.AdminRepository;
import com.hospitalmngmt.service.AdminService;

@Service
public class AdminServiceImpl implements AdminService
{
	@Autowired
	private AdminRepository adminRepository;

	

	public AdminServiceImpl(AdminRepository adminRepository) {
		super();
		this.adminRepository = adminRepository;
		
	}
	
	@Override
	public Admin saveAdmin(Admin admin) {
		System.out.println("admin register service" + admin);

		return adminRepository.save(admin);
	}
	
	@Override
	public Admin loginAdmin(Admin admin) {
		return 
				 this.adminRepository.findByAdminEmailIdAndAdminPassword(admin.adminEmailId, admin.adminPassword)
				.orElseThrow(() -> new ResourceNotFoundException("Admin ", "Id",
						admin.adminEmailId + "and password " + admin.adminPassword));
	}

	@Override
	public List<Admin> getAllAdmins() {
		return adminRepository.findAll();
	}

	@Override
	public Admin getAdminById(int adminId) {
		return adminRepository.findById(adminId).orElseThrow(()->new NoSuchElementException());
	}

	@Override
	public void deleteAdmin(int adminId) {
		 
		adminRepository.findById(adminId).orElseThrow(()->new ResourceNotFoundException("Admin","AdminId",adminId));
		adminRepository.deleteById(adminId);
		
	}

	@Override
	public Admin updateAdmin(Admin admin,int adminId) {
		
		Admin existingAdmin = adminRepository.findById(adminId).orElseThrow(()->new ResourceNotFoundException("Admin","AdminId",adminId));
		
		existingAdmin.setFirstName(admin.getFirstName());
		existingAdmin.setLastName(admin.getLastName());
		existingAdmin.setAdminEmailId(admin.getAdminEmailId());
		existingAdmin.setAdminPassword(admin.getAdminPassword());
		existingAdmin.setPhoneNumber(admin.getPhoneNumber());
		existingAdmin.setGender(admin.getGender());
		
		adminRepository.save(existingAdmin);
		
		return existingAdmin;
		
	}
	
	
}
