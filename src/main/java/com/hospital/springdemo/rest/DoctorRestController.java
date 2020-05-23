package com.hospital.springdemo.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hospital.springdemo.entity.Doctor;
import com.hospital.springdemo.service.DoctorService;

@RestController
@RequestMapping("/api")
public class DoctorRestController {
	
	

	@Autowired
	private DoctorService doctorService;
	
	@GetMapping("/doctors")
	public List<Doctor> getDoctors(){
		
		return doctorService.getDoctors();
	}
	
	
	@GetMapping("/doctors/{doctorId}")
	public Doctor getDoctor(@PathVariable int doctorId) {
		
		Doctor theDoctor = doctorService.getDoctor(doctorId);
		
		if(theDoctor == null) {
			throw new PatientNotFoundException("Customer id not found: " +
		doctorId);
		}
		
		return theDoctor;
	}
	
	//add maping for POST/doctor(add new doctor)
	@PostMapping("/doctors")
	public Doctor addDoctor(@RequestBody Doctor theDoctor) {
		
		theDoctor.setId(0);
		
		doctorService.saveDoctor(theDoctor);
		
		return theDoctor;
	}
	
	// add mapping for PUT / doctor - update
	
	@PutMapping("/doctors")
	public Doctor updateDoctor(@RequestBody Doctor theDoctor) {
		
		doctorService.saveDoctor(theDoctor);
		return theDoctor;
		
	}
	// delete doctor
	
	@DeleteMapping("/doctors/{doctorId}")
	public String deleteDoctor(@PathVariable int doctorId) {
		
		Doctor tempDoctor = doctorService.getDoctor(doctorId);
		
		if(tempDoctor == null) {
			throw new PatientNotFoundException("Doctor id not found: " +
					doctorId);
		}
		
		doctorService.deleteDoctor(doctorId);
		return "Deleted doctor:" + doctorId;
	}
	
	
}
