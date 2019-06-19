package org.com.finablr.health.service.impl;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.com.finablr.health.entity.DoctorSlotID;
import org.com.finablr.health.entity.DoctorsSlots;
import org.com.finablr.health.repo.AddDoctorsSlotRepository;
import org.com.finablr.health.repo.DoctorSlotsRepository;
import org.com.finablr.health.service.SlotGenrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SlotGenrationImpl implements SlotGenrationService{
	
	@Autowired
	private DoctorSlotsRepository doctorSlotsRepository;
	
	@Autowired
	private AddDoctorsSlotRepository addDoctorsSlotRepository;
	
	@Override
	public  void generateSlot(long doctorID, Date startDate,Date endDate, String openingTime, String closingTime, int appointmentGap) {
		
		Calendar start = Calendar.getInstance();
		start.setTime(startDate);
		Calendar end = Calendar.getInstance();
		end.setTime(endDate);
		end.add(Calendar.DATE, 1);  
		 int j = 1;
		for (Date date = start.getTime(); start.before(end); start.add(Calendar.DATE, 1), date = start.getTime()) {
		    Integer startHour = Integer.parseInt(openingTime.split(":")[0]);
		    Integer endHour = Integer.parseInt(closingTime.split(":")[0]);
		    Integer startMinutes = Integer.parseInt(openingTime.split(":")[1].split(" ")[0]);
		    Integer endMinutes = Integer.parseInt(closingTime.split(":")[1].split(" ")[0]);
		    
		    if(openingTime.split(" ")[1].equals("pm") && startHour < 12) {
		    	startHour = startHour + 12;
		    }
		    
		    if(closingTime.split(" ")[1].equals("pm") && endHour < 12) {
		    	endHour = endHour + 12;
		    }
		    
		    Calendar calendar1 = Calendar.getInstance();

		    int startRemMin = 0;
		    int startHour1 = startHour;


		    if(startMinutes > 0)
		    {
		    	startHour1 = startHour + 1;
		    	startRemMin = 60 - startMinutes;
		    }

		    int hourdiff = endHour - startHour1;

		    int totalMinutes = ((hourdiff * 60) + startRemMin + endMinutes)/appointmentGap;
		    
		   

		    for (int i = 0; i < totalMinutes; i++)
		    {
		    	 DoctorsSlots doctorSlots = new DoctorsSlots();
				 DoctorSlotID id= new DoctorSlotID();
				    
				 id.setSlotID(j++);
				 id.setDoctorID(doctorID);
				 id.setSessions("M");
				 id.setBookingDate(date);
		    	
		    	 calendar1.set(Calendar.HOUR_OF_DAY, startHour);
		    	 calendar1.set(Calendar.MINUTE, startMinutes);
		    	 String timeSlots =  String.format("%02d:%02d",calendar1.get(Calendar.HOUR_OF_DAY) , calendar1.get (Calendar.MINUTE));
		    	 startMinutes = startMinutes + appointmentGap;
		    	 
		    	 doctorSlots.setId(id);
				 doctorSlots.setSlotTime(timeSlots);
				 doctorSlots.setBlocked(false);
				 addDoctorsSlotRepository.save(doctorSlots);
				
		    }
		    
		      
		}
	}

	@Override
	public List<DoctorsSlots> findListsDoctors(long doctorID, Date bookingDate) {
		// TODO Auto-generated method stub
		return doctorSlotsRepository.findByIdDoctorIDAndIdBookingDate(doctorID, bookingDate);
	}

	@Override
	public void updateDoctorsSlot(long doctorID, String session, long slotId, boolean blocked) {
		// TODO Auto-generated method stub
		doctorSlotsRepository.setBlocked(doctorID,  session, slotId, blocked);
		
	}

}
