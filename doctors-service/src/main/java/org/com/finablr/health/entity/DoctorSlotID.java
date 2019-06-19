package org.com.finablr.health.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import javax.persistence.Embeddable;

@Embeddable
public class DoctorSlotID implements Serializable {
	
	private long doctorID;
	
	private long slotID;	
	
	private String sessions;
	
	private Date bookingDate;
	
	public DoctorSlotID() {
		super();
		// TODO Auto-generated constructor stub
	}
		

	public DoctorSlotID(long doctorID, long slotID, String sessions, Date bookingDate) {
		super();
		this.doctorID = doctorID;
		this.slotID = slotID;
		this.sessions = sessions;
		this.bookingDate = bookingDate;
	}

	
	public long getDoctorID() {
		return doctorID;
	}
	public void setDoctorID(long doctorID) {
		this.doctorID = doctorID;
	}


	public long getSlotID() {
		return slotID;
	}
	public void setSlotID(long slotID) {
		this.slotID = slotID;
	}


	public String getSessions() {
		return sessions;
	}


	public void setSessions(String sessions) {
		this.sessions = sessions;
	}
	
	public Date getBookingDate() {
		return bookingDate;
	}
	public void setBookingDate(Date bookingDate) {
		this.bookingDate = bookingDate;
	}
	
	
//	 @Override
//	    public boolean equals(Object o) {
//	        if (this == o) return true;
//	        if (!(o instanceof DoctorSlotID)) return false;
//	        DoctorSlotID that = (DoctorSlotID) o;
//	        return Objects.equals(getDoctorID(), that.getDoctorID()) &&
//	                Objects.equals(getSlotID(), that.getSlotID()) &&
//	                Objects.equals(getSessions(), that.getSessions()) &&
//	                Objects.equals(getBookingDate(), that.getBookingDate());
//	    }
//	 
//	    @Override
//	    public int hashCode() {
//	        return Objects.hash(getDoctorID(), getSlotID(),getSessions(),getBookingDate());
//	    }

}
