package org.com.finablr.health.service.impl;

import java.util.List;

import org.com.finablr.health.entity.Doctors;
import org.com.finablr.health.repo.SearchDoctorRepository;
import org.com.finablr.health.service.SearchDoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SearchDoctorServiceImpl implements SearchDoctorService{

	@Autowired
	private SearchDoctorRepository searchDoctorRepository;

	@Override
	public Doctors addDoctors(Doctors list) {
		// TODO Auto-generated method stub
		return searchDoctorRepository.save(list);
	}

	@Override
	public List<Doctors> findListsDoctors(String location, String specialist) {
		// TODO Auto-generated method stub
		return searchDoctorRepository.findByLocationAndSpecialist(location, specialist);
	}

	@Override
	public List<Doctors> doctorLogin(String userName, String password) {
		// TODO Auto-generated method stub
		return searchDoctorRepository.findByUserNameAndPassword(userName, password);
	}

//	@Override
//	public String listsDoctors(String location, String Specialist) {
//		// TODO Auto-generated method stub
//		return null;
//	}
	
	

}
