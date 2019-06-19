package com.unimoni.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class PatientBookingList {
	
	@Id	
	private String bookingID;
	
	private long doctorID;
	
	private String doctorName;
	
	private Date appointmentDate;
	
	private Date bookingDate;
	
	private String appointmentSession;

	private String appointmentTime;
	
	private String patientFirstName;
	
	private String patientLastName;
	
	private String mobileNo;
	
	private String email;
	
	private String diseaseDesc;
	
	private double consultationAmount;
	
	private long slotID;	
	
	
	public PatientBookingList() {
		super();
		// TODO Auto-generated constructor stub
	}


	public PatientBookingList(String bookingID, long doctorID, String doctorName, Date appointmentDate,
			Date bookingDate, String appointmentSession, String appointmentTime, String patientFirstName,
			String patientLastName, String mobileNo, String email, String diseaseDesc, double consultationAmount,
			long slotID) {
		super();
		this.bookingID = bookingID;
		this.doctorID = doctorID;
		this.doctorName = doctorName;
		this.appointmentDate = appointmentDate;
		this.bookingDate = bookingDate;
		this.appointmentSession = appointmentSession;
		this.appointmentTime = appointmentTime;
		this.patientFirstName = patientFirstName;
		this.patientLastName = patientLastName;
		this.mobileNo = mobileNo;
		this.email = email;
		this.diseaseDesc = diseaseDesc;
		this.consultationAmount = consultationAmount;
		this.slotID = slotID;
	}


	public String getBookingID() {
		return bookingID;
	}


	public void setBookingID(String bookingID) {
		this.bookingID = bookingID;
	}


	public long getDoctorID() {
		return doctorID;
	}


	public void setDoctorID(long doctorID) {
		this.doctorID = doctorID;
	}


	public String getDoctorName() {
		return doctorName;
	}


	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}


	public Date getAppointmentDate() {
		return appointmentDate;
	}


	public void setAppointmentDate(Date appointmentDate) {
		this.appointmentDate = appointmentDate;
	}


	public Date getBookingDate() {
		return bookingDate;
	}


	public void setBookingDate(Date bookingDate) {
		this.bookingDate = bookingDate;
	}


	public String getAppointmentSession() {
		return appointmentSession;
	}


	public void setAppointmentSession(String appointmentSession) {
		this.appointmentSession = appointmentSession;
	}


	public String getAppointmentTime() {
		return appointmentTime;
	}


	public void setAppointmentTime(String appointmentTime) {
		this.appointmentTime = appointmentTime;
	}


	public String getPatientFirstName() {
		return patientFirstName;
	}


	public void setPatientFirstName(String patientFirstName) {
		this.patientFirstName = patientFirstName;
	}


	public String getPatientLastName() {
		return patientLastName;
	}


	public void setPatientLastName(String patientLastName) {
		this.patientLastName = patientLastName;
	}


	public String getMobileNo() {
		return mobileNo;
	}


	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getDiseaseDesc() {
		return diseaseDesc;
	}


	public void setDiseaseDesc(String diseaseDesc) {
		this.diseaseDesc = diseaseDesc;
	}


	public double getConsultationAmount() {
		return consultationAmount;
	}


	public void setConsultationAmount(double consultationAmount) {
		this.consultationAmount = consultationAmount;
	}


	public long getSlotID() {
		return slotID;
	}


	public void setSlotID(long slotID) {
		this.slotID = slotID;
	}


	@Override
	public String toString() {
		return "PatientBookingList [bookingID=" + bookingID + ", doctorID=" + doctorID + ", doctorName=" + doctorName
				+ ", appointmentDate=" + appointmentDate + ", bookingDate=" + bookingDate + ", appointmentSession="
				+ appointmentSession + ", appointmentTime=" + appointmentTime + ", patientFirstName=" + patientFirstName
				+ ", patientLastName=" + patientLastName + ", mobileNo=" + mobileNo + ", email=" + email
				+ ", diseaseDesc=" + diseaseDesc + ", consultationAmount=" + consultationAmount + ", slotID=" + slotID
				+ "]";
	}

}
