package com.hospitalmngmt.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hospitalmngmt.entity.Appointment;

public interface AppointmentRepository extends JpaRepository<Appointment,Long>
{
	public List<Appointment> findBookingAppointmentByPatientId(int patientId);
}
