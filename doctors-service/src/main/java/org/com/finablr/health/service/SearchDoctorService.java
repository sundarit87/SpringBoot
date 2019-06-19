package org.com.finablr.health.service;

import java.util.List;

import org.com.finablr.health.entity.Doctors;
import org.springframework.stereotype.Component;

@Component
public interface SearchDoctorService {
	
	public Doctors addDoctors(Doctors list );
	
	public List<Doctors> findListsDoctors(String location, String specialist);
	
	//public String listsDoctors(String location, String Specialist);
	
	public List<Doctors> doctorLogin(String userName, String password);

}
