package com.hospital.springdemo.service;

import java.util.List;

import com.hospital.springdemo.entity.Doctor;

public interface DoctorService {

	public List<Doctor> getDoctors();

	public void saveDoctor(Doctor theDoctor);

	public Doctor getDoctor(int theId);

	public void deleteDoctor(int theId);
	
}
