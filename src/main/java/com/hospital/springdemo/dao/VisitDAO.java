package com.hospital.springdemo.dao;

import java.util.List;

import com.hospital.springdemo.entity.Visit;

public interface VisitDAO {

	public List<Visit> getVisits();

	public void saveVisit(Visit theVisit);

	public Visit getVisit(int theId);

	public void deleteVisit(int theId);
	
}
