package org.com.finablr.health.repo;

import java.util.List;

import org.com.finablr.health.entity.Doctors;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//public interface SearchDoctorRepository extends CrudRepository<ListsDoctors, Long>{
@Repository
public interface SearchDoctorRepository extends JpaRepository<Doctors, Long>{

	List<Doctors> findByLocationAndSpecialist(String location, String specialist);
	
	List<Doctors> findByUserNameAndPassword(String userName, String password);
	
	Doctors findByDName(String drName);
}
