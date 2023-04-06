package com.hospitalmngmt.service;

import java.util.List;

import javax.validation.Valid;

import com.hospitalmngmt.entity.Appointment;
import com.hospitalmngmt.exception.AppointmentNotValidException;

public interface AppointmentService {

	Appointment addAppointment(int doctorId, int patientId, @Valid Appointment appointment) throws AppointmentNotValidException;

	List<Appointment> getAllAppointments();

	Appointment getAppointmentById(long appointmentId);


}
