package com.unimoni.repo;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.unimoni.entity.PatientBookingList;

public interface AppointmentRepository extends JpaRepository<PatientBookingList, String>{
	
	List<PatientBookingList> findByDoctorIDAndAppointmentDate(long doctorID, Date appointmentDate);
	
	void deleteByBookingID(String bookingID);
	
	PatientBookingList findByBookingID(String bookingID);

}



