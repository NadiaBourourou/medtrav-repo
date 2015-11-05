package services.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import entities.Hotel;
import entities.HotelBooking;
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
	public Double calculPrix(Double prix, Double numNights) {
	
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
	
	

	


	}


