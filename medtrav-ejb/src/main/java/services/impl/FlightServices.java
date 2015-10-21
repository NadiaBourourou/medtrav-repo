package services.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import entities.Flight;
import services.interfaces.FlightServicesLocal;
import services.interfaces.FlightServicesRemote;

/**
 * Session Bean implementation class FlightServices
 */
@Stateless
public class FlightServices implements FlightServicesRemote, FlightServicesLocal {

	@PersistenceContext
	EntityManager entityManager;
    /**
     * Default constructor. 
     */
    public FlightServices() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public Boolean addFlight(Flight flight) {
		Boolean b = false;
		try {
			entityManager.merge(flight);
			b = true;

		} catch (Exception e) {
			System.err.println("Error adding flight");
		}
		return b;
	}

	@Override
	public Boolean updateFlight(Flight flight) {
		Boolean b = false;
		try {
			entityManager.merge(flight);
			b = true;

		} catch (Exception e) {
			System.err.println("Error updating flight");
		}
		return b;
	}

	@Override
	public Boolean deleteFlight(Flight flight) {
		Boolean b = false;
		try {
			Flight flightFound=entityManager.find(Flight.class, flight.getFlightId());
			entityManager.remove(flightFound);
			b = true;

		} catch (Exception e) {
			System.err.println("Error deleting flight");
		}
		return b;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Flight> findAllFlightsByPatientId(Integer patientId) {
		String jpql="select f from Flight f where f.patient.id =: param";
		Query query=entityManager.createQuery(jpql);
		query.setParameter("param", patientId);
		return query.getResultList();
	}

	@Override
	public Flight findFlightById(Integer idFlight) {
		return entityManager.find(Flight.class, idFlight);

	}

}
