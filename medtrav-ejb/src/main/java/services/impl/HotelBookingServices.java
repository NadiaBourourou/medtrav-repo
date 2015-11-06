package services.impl;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import entities.Hotel;
import entities.HotelBooking;
import entities.Patient;
import entities.RoomType;
import services.interfaces.HotelBookingServicesLocal;
import services.interfaces.HotelBookingServicesRemote;

/**
 * Session Bean implementation class HotelBookingServices
 */
@Stateless
public class HotelBookingServices implements HotelBookingServicesRemote, HotelBookingServicesLocal {

	@PersistenceContext
	EntityManager entityManager;
    /**
     * Default constructor. 
     */
    public HotelBookingServices() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public Double calculPrix(Double prix, Integer numNights) {
	
			return prix*numNights; 
		}
	
	
	

	@Override
	public Boolean addHotelBooking(HotelBooking hb) {
		Boolean b= false; 
		try {  entityManager.merge(hb);
		
			b= true;
		} catch (Exception e) {
			System.err.println("error");
		}
		return b;
	}
	
	@Override
	public Hotel findHotelByPatientId(Integer idPatient) {
		 String jpql = "select h from Hotel h join h.hotelBookings hbs where hbs.patient.userId=:param";
		 Query query= entityManager.createQuery(jpql);
		 query.setParameter("param", idPatient);
		 return  (Hotel) query.getSingleResult();
		
	}

	@Override
	public Boolean bookHotel(Integer numNights, Double price,
			RoomType roomType, Hotel hotel, Integer idPatient) {
		Boolean b = false;
		try {
			Patient patient= entityManager.find(Patient.class,idPatient);
			HotelBooking hotelBooking = new HotelBooking(numNights, price,
				roomType, hotel, patient);
			entityManager.merge(hotelBooking);
			b = true;
		} catch (Exception e) {
		}
		return b;
	}

	}
	
	

