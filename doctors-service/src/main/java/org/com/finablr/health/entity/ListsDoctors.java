package org.com.finablr.health.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;
@Entity
public class ListsDoctors {

	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long ID;
	
	@NotBlank
	@NotEmpty
	@NotNull
	@Size(min = 1, max = 5, message = "{EV100}")
	private String location;
	@NotBlank
	@NotEmpty
	@NotNull
	private String specialist;
	
	@JsonIgnore
	private String hospitalName;
	@JsonIgnore
	private String dName;
	
	private Date createdOn;
	
	
	
	public ListsDoctors() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

	public ListsDoctors(long iD,
			@NotBlank @NotEmpty @NotNull @Size(min = 1, max = 5, message = "{EV100}") String location,
			@NotBlank @NotEmpty @NotNull String specialist, String hospitalName, String dName, Date createdOn) {
		super();
		ID = iD;
		this.location = location;
		this.specialist = specialist;
		this.hospitalName = hospitalName;
		this.dName = dName;
		this.createdOn = createdOn;
	}



	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getSpecialist() {
		return specialist;
	}
	public void setSpecialist(String specialist) {
		this.specialist = specialist;
	}
	public String getHospitalName() {
		return hospitalName;
	}
	public void setHospitalName(String hospitalName) {
		this.hospitalName = hospitalName;
	}
	public String getdName() {
		return dName;
	}
	public void setdName(String dName) {
		this.dName = dName;
	}


	public long getID() {
		return ID;
	}


	public void setID(long iD) {
		ID = iD;
	}


	public Date getCreatedOn() {
		return createdOn;
	}


	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}
	
	
	
}
