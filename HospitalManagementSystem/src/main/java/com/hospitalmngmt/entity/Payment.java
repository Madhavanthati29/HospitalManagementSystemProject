package com.hospitalmngmt.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="payment_table")
@SequenceGenerator(name="payment", sequenceName="payment_gene", initialValue=6000)
public class Payment 
{
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="payment")
	private int paymentId;
	
	@Column(name="total_payment")
	private  int totalPayment;

	@Column(name="doctor_id")
	private  int doctorId;

	@Column(name="prescription_id",unique=true)
	private  int prescriptionId;
	
	@Column(name="pharmacist_id")
	private  int pharmacistId;

	@Column(name="admitDate")
	private Date admitDate;

	@Column(name="payment_Date")
	private Date paymentDate;

	@Column(name="payment_status")
	//@NotEmpty
	private String paymentStatus;

 	@Column(name="name_on_card") 
	//@NotEmpty
	@Size(min=3 , message="name must contain atleast 3 characters")
	private String nameOnCard;

	@Column(name="card_number")
	//@NotEmpty
	@Size(min=16 , max=16,message="cardNumber must contain 16 digits")
	private String cardNumber;

	@Column(name="exp_year")
	//@NotEmpty
	private String expYear;

	@Column(name="cvv")
	//@NotNull
	private int cvv;
	
	@Column(name="upi")
	private String upi;

	@ManyToOne( cascade=CascadeType.MERGE)
	@JoinColumn(name="patient_id")
	@JsonIgnore
	private Patient patient;

	public int getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(int paymentId) {
		this.paymentId = paymentId;
	}

	public int getTotalPayment() {
		return totalPayment;
	}

	public void setTotalPayment(int totalPayment) {
		this.totalPayment = totalPayment;
	}

	public int getDoctorId() {
		return doctorId;
	}

	public void setDoctorId(int doctorId) {
		this.doctorId = doctorId;
	}

	public int getPrescriptionId() {
		return prescriptionId;
	}

	public void setPrescriptionId(int prescriptionId) {
		this.prescriptionId = prescriptionId;
	}

	public int getPharmacistId() {
		return pharmacistId;
	}

	public void setPharmacistId(int pharmacistId) {
		this.pharmacistId = pharmacistId;
	}

	public Date getAdmitDate() {
		return admitDate;
	}

	public void setAdmitDate(Date admitDate) {
		this.admitDate = admitDate;
	}

	public Date getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(Date paymentDate) {
		this.paymentDate = paymentDate;
	}

	public String getPaymentStatus() {
		return paymentStatus;
	}

	public void setPaymentStatus(String paymentStatus) {
		this.paymentStatus = paymentStatus;
	}

	public String getNameOnCard() {
		return nameOnCard;
	}

	public void setNameOnCard(String nameOnCard) {
		this.nameOnCard = nameOnCard;
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public String getExpYear() {
		return expYear;
	}

	public void setExpYear(String expYear) {
		this.expYear = expYear;
	}

	public int getCvv() {
		return cvv;
	}

	public void setCvv(int cvv) {
		this.cvv = cvv;
	}

	public String getUpi() {
		return upi;
	}

	public void setUpi(String upi) {
		this.upi = upi;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	@Override
	public String toString() {
		return "Payment [paymentId=" + paymentId + ", totalPayment=" + totalPayment + ", doctorId=" + doctorId
				+ ", prescriptionId=" + prescriptionId + ", pharmacistId=" + pharmacistId + ", admitDate=" + admitDate
				+ ", paymentDate=" + paymentDate + ", paymentStatus=" + paymentStatus + ", nameOnCard=" + nameOnCard
				+ ", cardNumber=" + cardNumber + ", expYear=" + expYear + ", cvv=" + cvv + ", upi=" + upi + ", patient="
				+ patient + "]";
	}
}
