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
import com.hospital.springdemo.entity.Visit;
import com.hospital.springdemo.service.VisitService;

@RestController
@RequestMapping("/api")
public class VisitRestController {

	

	@Autowired
	private VisitService visitService;
	
	@GetMapping("/visits")
	public List<Visit> getVisits(){
		
		return visitService.getVisits();
	}
	
	@GetMapping("/visits/{visitId}")
	public Visit getVisit(@PathVariable int visitId) {
		
		Visit theVisit = visitService.getVisit(visitId);
		
		if(theVisit == null) {
			throw new PatientNotFoundException("Visit id not found: " +
		visitId);
		}
		
		return theVisit;
	}
	
	//add maping for POST/customers(add new customer)
	@PostMapping("/visits")
	public Visit addVisit(@RequestBody Visit theVisit) {
		
		theVisit.setId(0);
		
		visitService.saveVisit(theVisit);
		
		return theVisit;
	}
	
	// add mapping for PUT / customers - update
	
	@PutMapping("/visits")
	public Visit updateVisit(@RequestBody Visit theVisit) {
		
		visitService.saveVisit(theVisit);
		return theVisit;
		
	}
	
	
	@DeleteMapping("/visits/{visitId}")
	public String deleteVisit(@PathVariable int visitId) {
		
		Visit tempVisit = visitService.getVisit(visitId);
		
		if(tempVisit == null) {
			throw new PatientNotFoundException("Visit id not found: " +
					visitId);
		}
		
		visitService.deleteVisit(visitId);
		return "Deleted visit:" + visitId;
	}
	
	
}
