package com.hospitalmngmt.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;


@Entity
@Table(name = "doctor_table")
@SequenceGenerator(name="doctor",sequenceName="doctor_gene",initialValue=2000)
public class Doctor 
{
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="doctor")
	@Column(name="doctor_id")
	private int doctorId;
	
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
	public String doctorEmailId;
	
	@Column(name="doctor_age",length = 3)
	@NotNull
	public int doctorAge;
	
	@Column(name="doctor_specialist",unique=true,length=30)
	@NotEmpty
	public String doctorSpecialist;
	
	@Column(name="phone_number")
	@NotEmpty
	@Size(min=10 ,max=10, message="phoneNumber must contain  10 digits")
	private String phoneNumber;
	
	@Column(name="doctor_gender",length=30)
	@NotEmpty
	@Size(min=4 , message="gender must contain atleast 4 characters")
	public String doctorGender;
	
	@Column(name="doctor_password",length=20)
	@NotEmpty
	@Size(min=8, message="Password length must be 8 and contain uppercase,lowercase,digits")
	@Pattern(regexp="(?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).{8,}")
	public String doctorPassword;

	public int getDoctorId() {
		return doctorId;
	}

	public void setDoctorId(int doctorId) {
		this.doctorId = doctorId;
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

	public String getDoctorEmailId() {
		return doctorEmailId;
	}

	public void setDoctorEmailId(String doctorEmailId) {
		this.doctorEmailId = doctorEmailId;
	}

	public int getDoctorAge() {
		return doctorAge;
	}

	public void setDoctorAge(int doctorAge) {
		this.doctorAge = doctorAge;
	}

	public String getDoctorSpecialist() {
		return doctorSpecialist;
	}

	public void setDoctorSpecialist(String doctorSpecialist) {
		this.doctorSpecialist = doctorSpecialist;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getDoctorGender() {
		return doctorGender;
	}

	public void setDoctorGender(String doctorGender) {
		this.doctorGender = doctorGender;
	}

	public String getDoctorPassword() {
		return doctorPassword;
	}

	public void setDoctorPassword(String doctorPassword) {
		this.doctorPassword = doctorPassword;
	}

	@Override
	public String toString() {
		return "Doctor [doctorId=" + doctorId + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", doctorEmailId=" + doctorEmailId + ", doctorAge=" + doctorAge + ", doctorSpecialist="
				+ doctorSpecialist + ", phoneNumber=" + phoneNumber + ", doctorGender=" + doctorGender
				+ ", doctorPassword=" + doctorPassword + "]";
	}

	
		
}
