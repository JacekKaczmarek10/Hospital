package com.hospital.springdemo.service;

import java.util.List;

import com.hospital.springdemo.entity.Visit;

public interface VisitService {

	
	public List<Visit> getVisits();
	
	public void saveVisit(Visit theVisit);

	public Visit getVisit(int theId);

	public void deleteVisit(int theId);
}
