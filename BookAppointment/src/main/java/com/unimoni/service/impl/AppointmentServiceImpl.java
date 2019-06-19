package com.unimoni.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unimoni.DTO.User;
import com.unimoni.entity.PatientBookingList;
import com.unimoni.repo.AppointmentRepository;
import com.unimoni.service.AppointmentService;
import com.unimoni.service.DoctorSlotFeignClient;
import com.unimoni.service.KafkaNotificationFeignClient;

@Service
public class AppointmentServiceImpl implements AppointmentService{

	@Autowired
	private AppointmentRepository appointmentRepository;
	
	@Autowired
	private DoctorSlotFeignClient doctorSlotFeignClient;
	
	@Autowired
	private KafkaNotificationFeignClient kafkaNotificationFeignClient;
	

	@Override
	public PatientBookingList makeAppointment(PatientBookingList patientBookingList)  {
		
		
		PatientBookingList patientBooking = appointmentRepository.save(patientBookingList);
		
		doctorSlotFeignClient.updateDoctorsSlot(patientBookingList.getDoctorID(),
				patientBookingList.getAppointmentSession(), patientBookingList.getSlotID(), true);
		
		User user = new User();
		user.setUsername(patientBookingList.getEmail());
		user.setToken(patientBookingList.getBookingID());
		user.setText("Appointment Booked your booking ID : "+patientBookingList.getBookingID());
		user.setSubject("Dear User, Your doctor appointment was booked");
		
		//kafkaNotificationFeignClient.notify(user);
		
		return patientBooking;
	}
	
	

	@Override
	public List<PatientBookingList> getPatientBookingList(long doctorID, Date appointmentDate) {
		return appointmentRepository.findByDoctorIDAndAppointmentDate(doctorID, appointmentDate);
	}



	@Override
	public void cancelAppointment(String bookingID) {
		// TODO Auto-generated method stub
		PatientBookingList patientBooking = appointmentRepository.findByBookingID(bookingID);
		System.out.println(patientBooking.toString());
		appointmentRepository.deleteByBookingID(bookingID);
		//System.out.println("delete");
		
		doctorSlotFeignClient.updateDoctorsSlot(patientBooking.getDoctorID(),
				patientBooking.getAppointmentSession(), patientBooking.getSlotID(), false);
		
		User user = new User();
		user.setUsername(patientBooking.getEmail());
		user.setToken(patientBooking.getBookingID());
		user.setText("Appointment Cancelled your booking ID : "+patientBooking.getBookingID());
		user.setSubject("Dear User, Your doctor appointment was cancelled");
		
		//kafkaNotificationFeignClient.notify(user);
		
		
	}
	
	




}
