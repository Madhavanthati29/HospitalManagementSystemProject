package com.hospitalmngmt.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Table(name = "pharmacist_table")
@SequenceGenerator(name="pharmacist",sequenceName="pharmacist_gene",initialValue=5000)
public class Pharmacist 
{
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="pharmacist")
	@Column(name="pharmacist_id")
	private int pharmacistId;
	
	@Column(name="first_name",length=20)
	@NotEmpty
	@Size(min=3 , message="firstName must contain atleast 3 characters")
	public String firstName;
	
	@Column(name="last_name",length=20)
	@NotEmpty
	@Size(min=3 , message="lastName must contain atleast 3 characters")
	public String lastName;
	
	@Column(name="email_id",unique=true,length=30)
	@NotEmpty
	@Email(message="Email  is not valid!")
	public String pharmacistEmailId;
	
	@Column(name="pharmacist_age",length = 3)
	@NotNull
	public int pharmacistAge;
	
	@Column(name="phone_number")
	@NotEmpty
	@Size(min=10 ,max=10, message="phoneNumber must contain  10 digits")
	private String phoneNumber;
	
	@Column(name="pharmacist_gender",length=30)
	@NotEmpty
	@Size(min=4 , message="gender must contain atleast 4 characters")
	public String pharmacistGender;
	
	@Column(name="pharmacist_password",length=20)
	@NotEmpty
	@Size(min=8, message="Password length must be 8 and contain uppercase,lowercase,digits")
	@Pattern(regexp="(?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).{8,}")
	public String pharmacistPassword;

	public int getPharmacistId() {
		return pharmacistId;
	}

	public void setPharmacistId(int pharmacistId) {
		this.pharmacistId = pharmacistId;
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

	public String getPharmacistEmailId() {
		return pharmacistEmailId;
	}

	public void setPharmacistEmailId(String pharmacistEmailId) {
		this.pharmacistEmailId = pharmacistEmailId;
	}

	public int getPharmacistAge() {
		return pharmacistAge;
	}

	public void setPharmacistAge(int pharmacistAge) {
		this.pharmacistAge = pharmacistAge;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getPharmacistGender() {
		return pharmacistGender;
	}

	public void setPharmacistGender(String pharmacistGender) {
		this.pharmacistGender = pharmacistGender;
	}

	public String getPharmacistPassword() {
		return pharmacistPassword;
	}

	public void setPharmacistPassword(String pharmacistPassword) {
		this.pharmacistPassword = pharmacistPassword;
	}

	@Override
	public String toString() {
		return "Pharmacist [pharmacistId=" + pharmacistId + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", pharmacistEmailId=" + pharmacistEmailId + ", pharmacistAge=" + pharmacistAge + ", phoneNumber="
				+ phoneNumber + ", pharmacistGender=" + pharmacistGender + ", pharmacistPassword=" + pharmacistPassword
				+ "]";
	}

	
}
