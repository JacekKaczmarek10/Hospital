package com.hospital.springdemo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hospital.springdemo.entity.Doctor;

@Repository
public class DoctorDAOImpl implements DoctorDAO {

	// need to inject the session factory
	@Autowired
	private SessionFactory sessionFactory;
			
	@Override
	public List<Doctor> getDoctors() {
		
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
				
		// create a query  ... sort by last name
		Query<Doctor> theQuery = 
				currentSession.createQuery("from Doctor order by lastName",
											Doctor.class);
		
		// execute query and get result list
		List<Doctor> doctors = theQuery.getResultList();
				
		// return the results		
		return doctors;
	}

	@Override
	public void saveDoctor(Doctor theDoctor) {

		// get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// save/upate the customer ... finally LOL
		currentSession.saveOrUpdate(theDoctor);
		
	}

	@Override
	public Doctor getDoctor(int theId) {

		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// now retrieve/read from database using the primary key
		Doctor theDoctor = currentSession.get(Doctor.class, theId);
		
		return theDoctor;
	}

	@Override
	public void deleteDoctor(int theId) {

		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// delete object with primary key
		Query theQuery = 
				currentSession.createQuery("delete from Doctor where id=:doctorId");
		theQuery.setParameter("doctorId", theId);
		
		theQuery.executeUpdate();		
	}

}











