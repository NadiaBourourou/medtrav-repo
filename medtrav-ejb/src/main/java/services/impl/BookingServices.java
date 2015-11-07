package services.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import services.interfaces.BookingServicesLocal;
import services.interfaces.BookingServicesRemote;
import entities.Booking;
import entities.Clinic;
import entities.Hotel;

/**
 * Session Bean implementation class BookingServices
 */
@Stateless
public class BookingServices implements BookingServicesRemote,
		BookingServicesLocal {

	@PersistenceContext
	EntityManager entitymanager;

	public BookingServices() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Boolean addBooking(Booking booking) {
		Boolean b = false;
		try {
			entitymanager.merge(booking);
			b = true;

		} catch (Exception e) {
			System.err.println("Error ...");
		}
		return b;
	}

	@Override
	public Boolean updateBooking(Booking booking) {
		Boolean b = false;
		try {
			entitymanager.merge(booking);
			b = true;

		} catch (Exception e) {
			System.err.println("Error ...");
		}
		return b;
	}

	@Override
	public Boolean deleteBooking(Booking booking) {
		Boolean b = false;
		try {
			entitymanager.remove(findBookingById(booking.getBookingId()));
			b = true;
		} catch (Exception e) {
			System.err.println("Error");
		}

		return b;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Booking> findAllBookingsByPatient(Integer patientId) {
		String jpql = "select b from booking where b.patient.userId=:param";
		Query query = entitymanager.createQuery(jpql);
		query.setParameter("param", patientId);
		return query.getResultList();
	}

	@Override
	public Booking findBookingById(Integer idBooking) {
		return entitymanager.find(Booking.class, idBooking);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Booking> findAllBookingsByFlightId(Integer id) {
		String jpql = "select b from Booking b where b.flight.id=:param";
		Query query = entitymanager.createQuery(jpql);
		query.setParameter("param", id);
		return query.getResultList();
	}

	@Override
	public Hotel findHotelByPatientId(Integer idPatient) {
		String jpql = "select h from Hotel h join h.hotelBookings hbs where hbs.patient.userId=:param";
		Query query = entitymanager.createQuery(jpql);
		query.setParameter("param", idPatient);
		return (Hotel) query.getSingleResult();

	}

	@Override
	public Clinic findClinicByPatientId(Integer idPatient) {
		String jpql = "select c from Clinic c join c.clinicBookings cbs where cbs.patient.userId=:param";
		Query query = entitymanager.createQuery(jpql);
		query.setParameter("param", idPatient);
		return (Clinic) query.getSingleResult();

	}

}
