package com.hospitalmngmt.serviceImpl;

import java.text.ParseException;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hospitalmngmt.entity.Appointment;
import com.hospitalmngmt.entity.Doctor;
import com.hospitalmngmt.entity.Patient;
import com.hospitalmngmt.entity.Prescription;
import com.hospitalmngmt.exception.IdMismatchException;
import com.hospitalmngmt.exception.PrescriptionNotValidException;
import com.hospitalmngmt.exception.ResourceNotFoundException;
import com.hospitalmngmt.repository.PatientRepository;
import com.hospitalmngmt.repository.PrescriptionRepository;
import com.hospitalmngmt.service.AppointmentService;
import com.hospitalmngmt.service.DoctorService;
import com.hospitalmngmt.service.PatientService;
import com.hospitalmngmt.service.PrescriptionService;

@Service
public class PrescriptionServiceImpl implements PrescriptionService {
	@Autowired
	public PrescriptionRepository prescriptionRepository;

	@Autowired
	public PatientRepository patientRepository;

	@Autowired
	public AppointmentService appointmentService;

	@Autowired
	public PatientService patientService;

	@Autowired
	public DoctorService doctorService;

	@Override
	public Prescription generatePrescription(Prescription prescription, long appointmentId)
			throws ParseException, IdMismatchException, PrescriptionNotValidException {

		Appointment appointment = appointmentService.getAppointmentById(appointmentId);
		List<Prescription> prescriptions = prescriptionRepository.findAll();

		for (Prescription prescriptionsDetail : prescriptions) {
			Appointment appointment1 = prescriptionsDetail.getAppointment();
			if (prescriptionsDetail.getDoctorId() == prescription.getDoctorId()) {
				if (prescriptionsDetail.getPatientId() == prescription.getPatientId()) {
					if (appointment1.getAppointmentId() == appointmentId) {
						throw new PrescriptionNotValidException("Prescription is not valid :(");
					}
				}
			}
		}

		Doctor doctor = appointment.getDoctor();

		Doctor doctor1 = doctorService.getDoctorById(prescription.doctorId);
		Patient patient = patientService.getPatientById(prescription.patientId);

		if (doctor1.getDoctorId() != doctor.getDoctorId()) {
			throw new IdMismatchException("Doctor id is not matching please check that one ");
		} else if (patient.getPatientId() != appointment.getPatientId()) {
			throw new IdMismatchException("Patient id is not matching please check that one ");
		}

		prescription.setAppointment(appointment);

		return prescriptionRepository.save(prescription);

	}

	@Override
	public List<Prescription> getAllPrescriptions() {
		return prescriptionRepository.findAll();
	}

	@Override
	public void deletePrescription(int prescriptionId) 
	{
		prescriptionRepository.findById(prescriptionId).orElseThrow(()->new ResourceNotFoundException("Prescription","prescriptionId",prescriptionId));
		prescriptionRepository.deleteById(prescriptionId);
	}

	@Override
	public Prescription getPrescriptionById(int prescriptionId) {
		return prescriptionRepository.findById(prescriptionId).orElseThrow(()->new ResourceNotFoundException("prescription","PrescriptionId",prescriptionId));
	}

}
