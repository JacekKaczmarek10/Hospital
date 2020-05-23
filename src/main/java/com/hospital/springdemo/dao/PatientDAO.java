package com.hospital.springdemo.dao;

import java.util.List;

import com.hospital.springdemo.entity.Patient;

public interface PatientDAO {

	public List<Patient> getPatients();

	public void savePatient(Patient thePatient);

	public Patient getPatient(int theId);

	public void deletePatient(int theId);
	
}
