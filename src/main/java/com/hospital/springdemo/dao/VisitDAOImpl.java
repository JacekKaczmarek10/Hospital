package com.hospital.springdemo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hospital.springdemo.entity.Patient;
import com.hospital.springdemo.entity.Visit;

@Repository
public class VisitDAOImpl implements VisitDAO {

	// need to inject the session factory
	@Autowired
	private SessionFactory sessionFactory;
			
	@Override
	public List<Visit> getVisits() {
		
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
				
		// create a query  ... sort by last name
		Query<Visit> theQuery = 
				currentSession.createQuery("from Visit order by docId",
						Visit.class);
		
		// execute query and get result list
		List<Visit> visits = theQuery.getResultList();
				
		// return the results		
		return visits;
	}

	

	@Override
	public void saveVisit(Visit theVisit) {

		// get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// save/upate the customer ... finally LOL
		currentSession.saveOrUpdate(theVisit);
		
	}

	@Override
	public Visit getVisit(int theId) {

		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// now retrieve/read from database using the primary key
		Visit theVisit = currentSession.get(Visit.class, theId);
		
		return theVisit;
	}

	@Override
	public void deleteVisit(int theId) {

		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// delete object with primary key
		Query theQuery = 
				currentSession.createQuery("delete from Visit where id=:visitId");
		theQuery.setParameter("visitId", theId);
		
		theQuery.executeUpdate();		
	}

}



