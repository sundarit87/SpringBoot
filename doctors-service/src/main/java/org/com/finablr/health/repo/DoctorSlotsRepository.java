package org.com.finablr.health.repo;

import java.util.Date;
import java.util.List;

import org.com.finablr.health.entity.DoctorSlotID;
import org.com.finablr.health.entity.DoctorsSlots;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface DoctorSlotsRepository extends JpaRepository<DoctorsSlots, DoctorSlotID>{

	List<DoctorsSlots> findByIdDoctorIDAndIdBookingDate(Long doctorID, Date bookingDate);
	
	@Transactional
	@Modifying
	@Query("update DoctorsSlots set blocked=:blocked where doctorID=:doctorID and sessions=:session and slotID =:slotId")
	void setBlocked(@Param("doctorID") long doctorID,
			@Param("session") String session,@Param("slotId") long slotId,@Param("blocked") boolean blocked);
	
//	@Query("update DoctorsSlots set blocked=:blocked where doctorID=:doctorID and booking_date =:bookingDate and sessions=:session and slotID =:slotId")
//	void setBlocked(@Param("doctorID") long doctorID,@Param("bookingDate") Date bookingDate,
//			@Param("session") String session,@Param("slotId") long slotId,@Param("blocked") boolean blocked);
	

	
}
