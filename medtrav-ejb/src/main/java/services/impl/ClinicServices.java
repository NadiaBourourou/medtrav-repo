package services.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import entities.Clinic;
import entities.Hotel;
import entities.Patient;
import services.interfaces.ClinicServicesLocal;
import services.interfaces.ClinicServicesRemote;

/**
 * Session Bean implementation class ClinicServices
 */
@Stateless
public class ClinicServices implements ClinicServicesRemote, ClinicServicesLocal {
	@PersistenceContext
	EntityManager entityManager;
    /**
     * Default constructor. 
     */
    public ClinicServices() {
    	
    }

	@Override
	public Boolean addClinic(Clinic clinic) {
		Boolean b = false;
		try {
			entityManager.merge(clinic);
			b = true;

		} catch (Exception e) {
			System.err.println("Error ");
		}
		return b;
	}

	@Override
	public Boolean deleteClinicById(Integer id) {
		Boolean b = false;
		try {
			Clinic foundClinic = entityManager.find(Clinic.class, id);
			entityManager.remove(foundClinic);
			b = true;
		} catch (Exception e) {
			System.err.println("ouups ...");
		}
		return b;
	}

	@Override
	public Clinic findClinicById(Integer id) {
	
		return entityManager.find(Clinic.class, id);
	}

	@Override
	public Boolean updateClinic(Clinic clinic) {
		Boolean b = false;
		try {
			entityManager.merge(clinic);
			b = true;

		} catch (Exception e) {
			System.err.println("Error");
		}
		return b;
	}

	@Override
	public Boolean deleteClinic(Clinic clinic) {
		Boolean b = false;
		try {
			entityManager.remove(entityManager.merge(clinic));
			b = true;

		} catch (Exception e) {
			System.err.println("Error");
		}
		return b;
	}

	@Override
	public List<Clinic> findAllClinics() {
		String jpql = "select c from Clinic c ";
		Query query = entityManager.createQuery(jpql);
		return query.getResultList();
	}

	@Override
	public Clinic findClinicByName(String name) {
		 String jpql = "select h from Clinic h where h.name=:param";
		 Query query= entityManager.createQuery(jpql);
		 query.setParameter("param", name);
		 return (Clinic) query.getSingleResult();
	}
	}


