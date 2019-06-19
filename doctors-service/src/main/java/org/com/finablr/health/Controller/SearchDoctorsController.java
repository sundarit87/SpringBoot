package org.com.finablr.health.Controller;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.com.finablr.health.entity.Doctors;
import org.com.finablr.health.entity.DoctorsSlots;
import org.com.finablr.health.service.SearchDoctorService;
import org.com.finablr.health.service.SlotGenrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.PropertySource;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@CrossOrigin(origins="*", allowedHeaders="*")
@PropertySource("classpath:doctors.properties")
@Validated
@RefreshScope
public class SearchDoctorsController {
	
	@Value("${schema}")
    private String schema;
	
	@Value("${imageUploadPath}")
	public String UPLOAD_PATH;
    
    @Value("${imageRetieveURL}")
    public String imageRetieveURL;

	@Autowired
	private SearchDoctorService searchDoctorService;
	
	@Autowired
	private SlotGenrationService slotGenrationService;
	

//	@GetMapping("/search/")
//	public ListsDoctors listsDoctors(@Valid @ModelAttribute ListsDoctors list ){
//		return list;
//	}
	
//	@GetMapping("/listDoc/{location}/{specialist}")
//	public String listsDoc(@Size(min = 1) @NotBlank @PathVariable("location")  String location,
//			 @Size(min = 5) @PathVariable("specialist") String specialist){
//		return searchDoctorService.listsDoctors(location, specialist);
//	}
//	
//	@GetMapping("/add/")
//	public ListsDoctors addListsDoctors(@Valid @ModelAttribute ListsDoctors list ){
//		return searchDoctorRepository.save(list);
//	}
	
//	@PostMapping("/doctors/")
//	public Doctors addDoctors(@Valid @ModelAttribute Doctors list ){
//		return searchDoctorService.addDoctors(list);
//	}
	
//	@PostMapping("/doctorSlots/")
//	public DoctorsSlots addDoctorsSlot(@Valid @ModelAttribute DoctorsSlots list){
//		return addDoctorsSlotRepository.save(list);
//	}
	
	@PostMapping("/doctors")
	public void uploadFile(@RequestParam ("hospitalName") String hospitalName,@RequestParam ("location") String location,@RequestParam ("dName") String dName
			,@RequestParam ("contactNo") String contactNo,@RequestParam ("email") String email,@RequestParam ("address") String address
			,@RequestParam ("openingTime") String openingTime,@RequestParam ("closingTime") String closingTime,@RequestParam ("specialist") String specialist
			,@RequestParam ("education") String education,@RequestParam ("experience") String experience
			,@RequestParam ("userName") String userName,@RequestParam ("password") String password
			,@RequestParam ("pictures") MultipartFile pictures)
	{
		   
	   try
		{
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

		String dateString = format.format(new Date());
		Date   date       = format.parse(dateString);    
			
		String imagePath;
		byte[] bytefile = pictures.getBytes();
		Long currentTime= System.currentTimeMillis();
		Path files = Paths.get(UPLOAD_PATH+ currentTime + pictures.getOriginalFilename());
		imagePath = currentTime +  pictures.getOriginalFilename();
		
		Doctors doctorObj = new Doctors();
		doctorObj.setHospitalName(hospitalName);
		doctorObj.setLocation(location);
		doctorObj.setdName(dName);
		doctorObj.setContactNo(contactNo);
		doctorObj.setEmail(email);
		doctorObj.setAddress(address);
		doctorObj.setOpeningTime(openingTime);
		doctorObj.setClosingTime(closingTime);
		doctorObj.setSpecialist(specialist);
		doctorObj.setEducation(education);
		doctorObj.setExperience(experience);
		doctorObj.setUserName(userName);
		doctorObj.setPassword(password);
	//	doctorObj.setAppointmentGap(appointmentGap);
		doctorObj.setImageURL(imagePath);
		
		searchDoctorService.addDoctors(doctorObj);

		Files.write(files,bytefile);
		}
		catch(Exception e)
		{
			
		}

	}
	
	@GetMapping("/find/{location}/{specialist}")
	public List<Doctors> findListsDoctors(@Size(min = 1) @NotBlank @PathVariable("location")  String location,
			 @Size(min = 5) @PathVariable("specialist") String specialist){
		List<Doctors> doctorsList ;
		doctorsList = new ArrayList<Doctors>();
		Iterable<Doctors> iterable = searchDoctorService.findListsDoctors(location, specialist);
		for (Doctors doctor : iterable) {
			doctor.setImageURL(imageRetieveURL+doctor.getImageURL());
			doctorsList.add(doctor);
	      }
		System.out.println(doctorsList);
	      return doctorsList;
	}
	
	
	
//	@GetMapping("/find/{location}/{specialist}")
//	public List<Doctors> findListsDoctors(@Size(min = 1) @NotBlank @PathVariable("location")  String location,
//			 @Size(min = 5) @PathVariable("specialist") String specialist){
//		return searchDoctorService.findListsDoctors(location, specialist);
//				//searchDoctorRepository.findByLocationAndSpecialist(location, specialist);
//	}
	
	@GetMapping("/slots/{doctorID}/{bookingDate}")
	public List<DoctorsSlots> findListsDoctors(@PathVariable("doctorID")  long doctorID,
			 @PathVariable("bookingDate") Date bookingDate){
		return slotGenrationService.findListsDoctors(doctorID, bookingDate);
				//doctorSlotsRepository.findByIdDoctorIDAndIdBookingDate(doctorID, bookingDate);
	}
	
	
	@PutMapping("/slotBooking/")
	public void updateDoctorsSlot(@RequestParam("doctorID")  long doctorID,
			@RequestParam("session")  String session,
			@RequestParam("slotId") long slotId, @RequestParam("blocked") boolean blocked){
		slotGenrationService.updateDoctorsSlot(doctorID, session, slotId, blocked);
		//doctorSlotsRepository.setBlocked(doctorID,  session, slotId, blocked);
	}
	
	@PostMapping("/slotGenration/{doctorID}/{startDate}/{endDate}/{openingTime}/{closingTime}/{appointmentGap}")
	public void genrateDoctorsSlot(@PathVariable("doctorID")  long doctorID,@PathVariable("startDate")  Date startDate,
			@PathVariable("endDate")  Date endDate,@PathVariable("openingTime")  String openingTime,
			 @PathVariable("closingTime") String closingTime, @PathVariable("appointmentGap") int appointmentGap){
		slotGenrationService.generateSlot(doctorID, startDate, endDate, openingTime, closingTime, appointmentGap);
	}
	
	
	@GetMapping("/config")
	public String getConfig(){
		return schema;
	}
	
	@GetMapping("/login/")
	public List<Doctors> doctorLogin(@RequestParam(name = "userName") String userName,
			@RequestParam(name = "password") String password){
		return searchDoctorService.doctorLogin(userName, password);
				//searchDoctorRepository.findByUserNameAndPassword(userName, password);
	}
	
}
