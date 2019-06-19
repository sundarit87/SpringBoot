package com.unimoni.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.unimoni.entity.PatientBookingList;
import com.unimoni.service.AppointmentService;

@RestController("/appointments")
@CrossOrigin(origins="*", allowedHeaders="*")
public class MakeAppointmentController {
	
	@Autowired
	private AppointmentService appointmentService;

	@GetMapping("/getPatientBookingList/")
	public List<PatientBookingList> getPatientBookingList(
			@RequestParam("doctorID") long doctorID,
			@RequestParam("appointmentDate") Date appointmentDate) {
		//return appointmentRepository.findByDoctorIDAndAppointmentDate(doctorID, appointmentDate);
		return appointmentService.getPatientBookingList(doctorID, appointmentDate);
		
	}

	@PostMapping("/makeAppointment")
	public PatientBookingList makeAppointment(@ModelAttribute PatientBookingList patientList) {
		return appointmentService.makeAppointment(patientList);
	}
	
	@Transactional
	@DeleteMapping("/cancelAppointment")
	public void cancelAppointment(@RequestParam(name = "bookingID") String bookingID) {
	 
	 appointmentService.cancelAppointment(bookingID);

	}

}
