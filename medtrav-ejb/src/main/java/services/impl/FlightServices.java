package services.impl;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import entities.Booking;
import entities.Doctor;
import entities.Flight;
import entities.Hotel;
import entities.MedicalRecords;
import entities.Surgery;
import services.interfaces.BookingServicesLocal;
import services.interfaces.FlightServicesLocal;
import services.interfaces.FlightServicesRemote;
import services.interfaces.SurgeryServicesLocal;

/**
 * Session Bean implementation class FlightServices
 */
@Stateless
public class FlightServices implements FlightServicesRemote,
		FlightServicesLocal {

	@PersistenceContext
	EntityManager entityManager;

	@EJB
	private BookingServicesLocal bookingServicesLocal;

	@EJB
	private SurgeryServicesLocal surgeryServicesLocal;

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
			Flight flightFound = entityManager.find(Flight.class,
					flight.getFlightId());
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
		String jpql = "select f from Flight f where f.patient.id =: param";
		Query query = entityManager.createQuery(jpql);
		query.setParameter("param", patientId);
		return query.getResultList();
	}

	@Override
	public Flight findFlightById(Integer idFlight) {
		return entityManager.find(Flight.class, idFlight);

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Flight> findFlightsByAirline(String airline) {
			String jpql = "select f from Flight f where f.airline=:airline";
			Query query = entityManager.createQuery(jpql);
			query.setParameter("param", airline);
			return query.getResultList();
	}

	@Override
	public Boolean assignFlightToBooking(Integer idBooking, Integer idFlight) {
		Boolean b = false;
		try {
			Booking bookingFound = bookingServicesLocal
					.findBookingById(idBooking);

			Flight flightFound = entityManager.find(Flight.class, idFlight);

			bookingFound.setFlight(flightFound);

			entityManager.merge(bookingFound);
			b = true;

		} catch (Exception e) {
			System.err.println("ouups ...");
		}

		return b;
	}

	@Override
	public Boolean assignFlightToBookingSlaveSide(Integer idBooking,
			Integer idFlight) {
		Boolean b = false;
		try {
			Booking bookingFound = bookingServicesLocal
					.findBookingById(idBooking);

			Flight flightFound = entityManager.find(Flight.class, idFlight);

			List<Booking> bookings = bookingServicesLocal
					.findAllBookingsByFlightId(idFlight);

			bookings.add(bookingFound);

			flightFound.linkBookingsToThisFlight(bookings);

			entityManager.merge(flightFound);

			b = true;

		} catch (Exception e) {
			System.err.println("ouups ...");
		}

		return b;
	}

	@Override
	public Boolean assignDoctorToSurgery(Integer idSurgery, Integer idDoctor) {
		Boolean b = false;
		try {
			Surgery surgeryFound = surgeryServicesLocal
					.findSurgeryById(idSurgery);

			Doctor doctorFound = entityManager.find(Doctor.class, idDoctor);

			surgeryFound.setDoctor(doctorFound);

			entityManager.merge(surgeryFound);
			b = true;

		} catch (Exception e) {
			System.err.println("ouups ...");
		}

		return b;
	}

	@Override
	public Boolean assignDoctorToSurgerySlaveSide(Integer idSurgery,
			Integer idDoctor) {

		Boolean b = false;
		try {
			Surgery surgeryFound = surgeryServicesLocal
					.findSurgeryById(idSurgery);

			Doctor doctorFound = entityManager.find(Doctor.class, idDoctor);

			List<Surgery> surgeries = surgeryServicesLocal
					.findAllSurgeriesByDoctorId(idDoctor);

			surgeries.add(surgeryFound);

			doctorFound.linkSurgeriesToThisDoctor(surgeries);

			entityManager.merge(doctorFound);

			b = true;

		} catch (Exception e) {
			System.err.println("ouups ...");
		}

		return b;
	}

	@Override
	public Boolean assignMedicalRecordToSurgery(Integer idSurgery,
			Integer idMedicalRecord) {
		Boolean b = false;
		try {
			Surgery surgeryFound = surgeryServicesLocal
					.findSurgeryById(idSurgery);

			MedicalRecords medicalRecordFound = entityManager.find(
					MedicalRecords.class, idMedicalRecord);

			surgeryFound.setMedicalRecords(medicalRecordFound);

			entityManager.merge(surgeryFound);
			b = true;

		} catch (Exception e) {
			System.err.println("ouups ...");
		}

		return b;
	}

	@Override
	public Boolean assignMedicalRecordToSurgerySlaveSide(Integer idSurgery,
			Integer idMedicalRecord) {
		Boolean b = false;
		try {
			Surgery surgeryFound = surgeryServicesLocal
					.findSurgeryById(idSurgery);

			MedicalRecords medicalRecordsFound = entityManager.find(MedicalRecords.class, idMedicalRecord);

			List<Surgery> surgeries = surgeryServicesLocal
					.findAllSurgeriesByMedicalRecordsId(idMedicalRecord);

			surgeries.add(surgeryFound);

			medicalRecordsFound.linkSurgeriesToThisMedicalRecords(surgeries);

			entityManager.merge(medicalRecordsFound);

			b = true;

		} catch (Exception e) {
			System.err.println("ouups ...");
		}

		return b;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<String> findAllDepartures() {
		String jpql = "select f.departure from FlightMatching f";
		Query query = entityManager.createQuery(jpql);
		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<String> findAllArrivals() {
		String jpql = "select f.arrival from FlightMatching f";
		Query query = entityManager.createQuery(jpql);
		return query.getResultList();
	}
	
	@Override
	public Flight findFlightByPatientId(Integer idPatient) {
		 String jpql = "select f from Flight f patient.userId=:param";
		 Query query= entityManager.createQuery(jpql);
		 query.setParameter("param", idPatient);
		 return  (Flight) query.getSingleResult();
		
	}
	
	
	

}
