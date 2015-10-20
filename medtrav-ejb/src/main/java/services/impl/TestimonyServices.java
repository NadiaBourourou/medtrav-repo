package services.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import entities.Testimony;
import services.interfaces.TestimonyServicesLocal;
import services.interfaces.TestimonyServicesRemote;

/**
 * Session Bean implementation class TestimonyServices
 */
@Stateless
public class TestimonyServices implements TestimonyServicesRemote, TestimonyServicesLocal {

	@PersistenceContext
	EntityManager entitymanager;

    /**
     * Default constructor. 
     */
    public TestimonyServices() {
        // TODO Auto-generated constructor stub
    }
	

	@Override
	public Boolean addTestimony(Testimony testimony) {
		Boolean b = false;
		try {
			entitymanager.merge(testimony);
			b = true;

		} catch (Exception e) {
			System.err.println("Error ...");
		}
		return b;
	}


	@Override
	public Boolean updateTestimony(Testimony testimony) {
		Boolean b = false;
		try {
			entitymanager.merge(testimony);
			b = true;

		} catch (Exception e) {
			System.err.println("Error ...");
		}
		return b;
	}


	@Override
	public Boolean deleteTestimony(Testimony testimony) {
		Boolean b = false;
		try {
			Testimony testimonyFound=entitymanager.find(Testimony.class, testimony.getTestimonyId());
			entitymanager.remove(testimonyFound);
			b = true;

		} catch (Exception e) {
			System.err.println("Error ...");
		}
		return b;
		
	}	
	


	@Override
	public List<Testimony> findAllTestimoniesByPatientId(Integer patientId) {
		String jpql="select t from Testimony t where t.patient.id =: param";
		Query query=entitymanager.createQuery(jpql);
		query.setParameter("param", patientId);
		return query.getResultList();
	
	}


	@Override
	public Testimony findTestimonyById(Integer idTestimony) {
		// TODO Auto-generated method stub
		return entitymanager.find(Testimony.class, idTestimony);
	}
}
