package com.hospitalmngmt.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;


@Entity
@Table(name = "admin_table")
public class Admin 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "admin_id")
	private int adminId;

	@Column(name = "first_name", length = 20)
	@NotEmpty
	@Size(min = 3, message = "firstName must contain atleast 3 characters")
	public String firstName;

	@Column(name = "last_name", length = 20)
	@NotEmpty
	@Size(min = 3, message = "lastName must contain atleast 3 characters")
	public String lastName;
	
	@Column(name = "email_id", unique = true, length = 30)
	@NotEmpty
	@Email(message = "Email  is not valid!")
	public String adminEmailId;
	
	@Column(name="phone_number")
	@NotEmpty
	@Size(min=10 ,max=10, message="phoneNumber must contain  10 digits")
	private String phoneNumber;
	
	@Column(name="gender",length=30)
	@NotEmpty
	@Size(min=4 , message="gender must contain atleast 4 characters")
	public String gender;
	
	@Column(name = "admin_password", length = 20)
	@NotEmpty
	@Size(min = 8, message = "Password length must be 8 and contain uppercase,lowercase,digits")
	@Pattern(regexp = "(?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).{8,}")
	public String adminPassword;

	public int getAdminId() {
		return adminId;
	}

	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getAdminEmailId() {
		return adminEmailId;
	}

	public void setAdminEmailId(String adminEmailId) {
		this.adminEmailId = adminEmailId;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getAdminPassword() {
		return adminPassword;
	}

	public void setAdminPassword(String adminPassword) {
		this.adminPassword = adminPassword;
	}

	@Override
	public String toString() {
		return "Admin [adminId=" + adminId + ", firstName=" + firstName + ", lastName=" + lastName + ", adminEmailId="
				+ adminEmailId + ", phoneNumber=" + phoneNumber + ", gender=" + gender + ", adminPassword="
				+ adminPassword + "]";
	}

	
}
