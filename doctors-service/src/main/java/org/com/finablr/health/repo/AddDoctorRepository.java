package org.com.finablr.health.repo;

import org.com.finablr.health.entity.Doctors;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddDoctorRepository extends JpaRepository<Doctors, Long>{

}


