package org.com.finablr.health.entity;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
public class DoctorsSlots{
	
//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	private Long id;
	
	@EmbeddedId 
	private DoctorSlotID id;
     
//	@Id
//	private long doctorID;
//	
//	@Id
//	private long slotID;
//	
//	@Id
//	private String sessions;
//	
//	@Id
//	private Date bookingDate;
	
	private String slotTime;
	
	private boolean blocked;
		

	public DoctorsSlots() {
		super();
		// TODO Auto-generated constructor stub
	}
		

//	public DoctorsSlots(long doctorID, long slotID, String sessions, Date bookingDate,
//			String slotTime, Boolean blocked
//		) {
//		super();
//		this.doctorID = doctorID;
//		this.slotID = slotID;
//		this.sessions = sessions;
//		this.bookingDate = bookingDate;
//		this.slotTime = slotTime;
//		this.blocked = blocked;
//	}
	
	public DoctorsSlots(DoctorSlotID id, String slotTime, Boolean blocked) {
		super();
		this.id = id;
		this.slotTime = slotTime;
		this.blocked = blocked;
	}

//	public Long getId() {
//		return id;
//	}
//
//
//	public void setId(Long id) {
//		this.id = id;
//	}




//	public long getDoctorID() {
//		return doctorID;
//	}
//
//
//	public void setDoctorID(long doctorID) {
//		this.doctorID = doctorID;
//	}
//
//
//	public long getSlotID() {
//		return slotID;
//	}
//
//
//	public void setSlotID(long slotID) {
//		this.slotID = slotID;
//	}
//
//
//	public String getSessions() {
//		return sessions;
//	}
//
//
//	public void setSessions(String sessions) {
//		this.sessions = sessions;
//	}
//
//
//	public Date getBookingDate() {
//		return bookingDate;
//	}
//
//
//	public void setBookingDate(Date bookingDate) {
//		this.bookingDate = bookingDate;
//	}


	public DoctorSlotID getId() {
		return id;
	}


	public void setId(DoctorSlotID id) {
		this.id = id;
	}


	public String getSlotTime() {
		return slotTime;
	}
	public void setSlotTime(String slotTime) {
		this.slotTime = slotTime;
	}


	public boolean isBlocked() {
		return blocked;
	}
	
	public void setBlocked(boolean blocked) {
		this.blocked = blocked;
	}
	
}


