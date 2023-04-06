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
import javax.validation.constraints.Size;

@Entity
@Table(name = "patient_table")
@SequenceGenerator(name="patient",sequenceName="patient_gene",initialValue=3000)
public class Patient 
{
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="patient")
	@Column(name="patient_id")
	private int patientId;
	
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
	public String patientEmailId;
	
	@Column(name="patient_age",length = 3)
	@NotNull
	public int patienttAge;
	
	@Column(name="phone_number")
	@NotEmpty
	@Size(min=10 ,max=10, message="phoneNumber must contain  10 digits")
	private String phoneNumber;
	
	@Column(name="blood_group",length=10)
	@NotEmpty
	@Size(min=3 , message="lastName must contain atleast 3 characters")
	public String bloodGroup;
	
	@Column(name="patient_gender",length=30)
	@NotEmpty
	@Size(min=4 , message="gender must contain atleast 4 characters")
	public String patientGender;
	
	@Column(name="doctor_id")
	public int doctorId;

	public int getPatientId() {
		return patientId;
	}

	public void setPatientId(int patientId) {
		this.patientId = patientId;
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

	public String getPatientEmailId() {
		return patientEmailId;
	}

	public void setPatientEmailId(String patientEmailId) {
		this.patientEmailId = patientEmailId;
	}

	public int getPatienttAge() {
		return patienttAge;
	}

	public void setPatienttAge(int patienttAge) {
		this.patienttAge = patienttAge;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getBloodGroup() {
		return bloodGroup;
	}

	public void setBloodGroup(String bloodGroup) {
		this.bloodGroup = bloodGroup;
	}

	public String getPatientGender() {
		return patientGender;
	}

	public void setPatientGender(String patientGender) {
		this.patientGender = patientGender;
	}

	public int getDoctorId() {
		return doctorId;
	}

	public void setDoctorId(int doctorId) {
		this.doctorId = doctorId;
	}

	@Override
	public String toString() {
		return "Patient [patientId=" + patientId + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", patientEmailId=" + patientEmailId + ", patienttAge=" + patienttAge + ", phoneNumber=" + phoneNumber
				+ ", bloodGroup=" + bloodGroup + ", patientGender=" + patientGender + ", doctorId=" + doctorId + "]";
	}

	
}
