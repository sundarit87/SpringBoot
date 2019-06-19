package org.com.finablr.health.service;

import java.util.Date;
import java.util.List;

import org.com.finablr.health.entity.DoctorsSlots;
import org.springframework.stereotype.Component;

@Component
public interface SlotGenrationService {
	
	public List<DoctorsSlots> findListsDoctors(long doctorID,Date bookingDate);
	
	public void updateDoctorsSlot(long doctorID, String session, long slotId, boolean blocked);;
	
	public void generateSlot(long doctorID, Date startDate,Date endDate, String openingTime, String closingTime, int appointmentGap);

}
