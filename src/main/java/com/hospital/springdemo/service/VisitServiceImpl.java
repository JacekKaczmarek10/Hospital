package com.hospital.springdemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hospital.springdemo.dao.VisitDAO;
import com.hospital.springdemo.entity.Visit;

@Service
public class VisitServiceImpl implements VisitService {

	// need to inject customer dao
	@Autowired
	private VisitDAO visitDAO;
	
	@Override
	@Transactional
	public List<Visit> getVisits() {
		return visitDAO.getVisits();
	}
	
	@Override
	@Transactional
	public void saveVisit(Visit theVisit) {

		visitDAO.saveVisit(theVisit);
	}

	@Override
	@Transactional
	public Visit getVisit(int theId) {
		
		return visitDAO.getVisit(theId);
	}

	@Override
	@Transactional
	public void deleteVisit(int theId) {
		
		visitDAO.deleteVisit(theId);
	}

}