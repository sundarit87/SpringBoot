package com.unimoni.service;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

import com.unimoni.entity.PatientBookingList;

@Component
public interface AppointmentService {
	
	public PatientBookingList makeAppointment(PatientBookingList patientBookingList);
	
	public List<PatientBookingList> getPatientBookingList(long doctorID, Date appointmentDate);
	
	public void cancelAppointment(String bookingID);
}

