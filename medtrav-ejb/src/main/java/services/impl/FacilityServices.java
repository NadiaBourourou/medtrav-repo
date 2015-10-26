package services.impl;

import java.util.List;




import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import entities.Facility;
import services.interfaces.FacilityServicesLocal;
import services.interfaces.FacilityServicesRemote;

import javax.persistence.Query;

/**
 * Session Bean implementation class FacilityServices
 */
@Stateless
public class FacilityServices implements FacilityServicesRemote, FacilityServicesLocal {

    /**
     * Default constructor. 
     */
    public FacilityServices() {
        // TODO Auto-generated constructor stub
    }

	@PersistenceContext
	private EntityManager entityManager;

	

	@Override
	public Boolean addFacility(Facility Facility) {
		Boolean b = false;
		try {
			entityManager.persist(Facility);
			b = true;
		} catch (Exception e) {
			System.err.println("Error");
		}
		return b;
	}

	@Override
	public Boolean deleteFacilityById(Integer id) {
		Boolean b = false;
		try {
			entityManager.remove(findFacilityById(id));
			b = true;
		} catch (Exception e) {
			System.err.println("Error");
		}
		return b;
	}

	@Override
	public Facility findFacilityById(Integer id) {
		return entityManager.find(Facility.class, id);
	}

	@Override
	public Boolean updateFacility(Facility Facility) {
		Boolean b = false;
		try {
			entityManager.merge(Facility);
			b = true;
		} catch (Exception e) {
			System.err.println("Error");
		}
		return b;
	}

	@Override
	public Boolean deleteFacility(Facility Facility) {
		Boolean b = false;
		try {
			entityManager.remove(entityManager.merge(Facility));
			b = true;
		} catch (Exception e) {
			System.err.println("Error");
		}
		return b;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Facility> findAllFacilities() {
		String jpql = "select f from Facility f";
		Query query = entityManager.createQuery(jpql);
		return query.getResultList();
	}

}


