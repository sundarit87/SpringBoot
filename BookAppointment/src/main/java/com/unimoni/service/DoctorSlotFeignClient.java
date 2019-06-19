package com.unimoni.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("Search-Doctor")
public interface DoctorSlotFeignClient {

	@PutMapping("/slotBooking/")
	public void updateDoctorsSlot(@RequestParam("doctorID")  long doctorID,
			@RequestParam("session")  String session,
			@RequestParam("slotId") long slotId, @RequestParam("blocked") boolean blocked);
	
	@GetMapping("/hell0")
	public String hello();
}
