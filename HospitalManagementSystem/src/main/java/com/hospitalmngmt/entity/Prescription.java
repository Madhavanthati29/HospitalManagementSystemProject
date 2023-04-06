package com.hospitalmngmt.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "prescription_table")
@SequenceGenerator(name="prescription",sequenceName="prescription_gene",initialValue=4000)
public class Prescription 
{
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="prescription")
	@Column(name="prescription_id")
	private int prescriptionId;
	
	@OneToOne( cascade=CascadeType.MERGE) 
	@JoinColumn(name="appointment_id")
	@JsonIgnore
	@OnDelete(action=OnDeleteAction.CASCADE) 
	public Appointment appointment;
	
	@Column(name="patient_id")
	public int patientId;

	@Column(name="doctor_id")
	public int doctorId;
	
	@Column(name="status")
	@NotEmpty
	public String status;

	public int getPrescriptionId() {
		return prescriptionId;
	}

	public void setPrescriptionId(int prescriptionId) {
		this.prescriptionId = prescriptionId;
	}

	public Appointment getAppointment() {
		return appointment;
	}

	public void setAppointment(Appointment appointment) {
		this.appointment = appointment;
	}

	public int getPatientId() {
		return patientId;
	}

	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}

	public int getDoctorId() {
		return doctorId;
	}

	public void setDoctorId(int doctorId) {
		this.doctorId = doctorId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Prescription [prescriptionId=" + prescriptionId + ", appointment=" + appointment + ", patientId="
				+ patientId + ", doctorId=" + doctorId + ", status=" + status + "]";
	}
	
	

	
}
