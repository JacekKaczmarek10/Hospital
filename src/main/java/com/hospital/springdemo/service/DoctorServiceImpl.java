package com.hospital.springdemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hospital.springdemo.dao.DoctorDAO;
import com.hospital.springdemo.entity.Doctor;

@Service
public class DoctorServiceImpl implements DoctorService {

	// need to inject customer dao
	@Autowired
	private DoctorDAO doctorDAO;
	
	@Override
	@Transactional
	public List<Doctor> getDoctors() {
		return doctorDAO.getDoctors();
	}

	@Override
	@Transactional
	public void saveDoctor(Doctor theDoctor) {

		doctorDAO.saveDoctor(theDoctor);
	}

	@Override
	@Transactional
	public Doctor getDoctor(int theId) {
		
		return doctorDAO.getDoctor(theId);
	}

	@Override
	@Transactional
	public void deleteDoctor(int theId) {
		
		doctorDAO.deleteDoctor(theId);
	}
}





