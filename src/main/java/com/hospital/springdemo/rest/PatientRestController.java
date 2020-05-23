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

import com.hospital.springdemo.entity.Patient;
import com.hospital.springdemo.service.PatientService;



@RestController
@RequestMapping("/api")
public class PatientRestController {

	
	@Autowired
	private PatientService patientService;
	
	
	
	@GetMapping("/patients")
	public List<Patient> getPatients(){
		
		return patientService.getPatients();
	}
	

	
	@GetMapping("/patients/{patientId}")
	public Patient getPatient(@PathVariable int patientId) {
		
		Patient thePatient = patientService.getPatient(patientId);
		
		if(thePatient == null) {
			throw new PatientNotFoundException("Patient id not found: " +
					patientId);
		}
		
		return thePatient;
	}
	
	//add maping for POST/customers(add new customer)
	@PostMapping("/patients")
	public Patient addPatient(@RequestBody Patient thePatient) {
		
		thePatient.setId(0);
		
		patientService.savePatient(thePatient);
		
		return thePatient;
	}
	
	// add mapping for PUT / customers - update
	
	@PutMapping("/patients")
	public Patient updatePatient(@RequestBody Patient thePatient) {
		
		patientService.savePatient(thePatient);
		return thePatient;
		
	}
	
	
	@DeleteMapping("/patients/{patientId}")
	public String deletePatient(@PathVariable int patientId) {
		
		Patient tempPatient = patientService.getPatient(patientId);
		
		if(tempPatient == null) {
			throw new PatientNotFoundException("Patient id not found: " +
					patientId);
		}
		
		patientService.deletePatient(patientId);
		return "Deleted patient:" + patientId;
	}
	
	
	
	
}
