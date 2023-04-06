package com.hospitalmngmt.service;

import java.util.List;

import com.hospitalmngmt.entity.Admin;

public interface AdminService {
	Admin saveAdmin(Admin admin);

	Admin loginAdmin(Admin admin);

	List<Admin> getAllAdmins();

	Admin getAdminById(int adminId);

	Admin updateAdmin(Admin admin, int adminId);

	void deleteAdmin(int adminId);
}
