package services.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import entities.Hotel;
import services.interfaces.HotelServicesLocal;
import services.interfaces.HotelServicesRemote;

/**
 * Session Bean implementation class HotelServices
 */
@Stateless
public class HotelServices implements HotelServicesRemote, HotelServicesLocal {

	@PersistenceContext
	EntityManager entityManager;
    /**
     * Default constructor. 
     */
    public HotelServices() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public Boolean addHotel(Hotel hotel) {
		Boolean b= false;
		try {
			entityManager.persist(hotel);
			b= true;
		}
		catch (Exception e) {
			System.err.println ("erreur");
		}
		return b;
	}

	@Override
	public Boolean deleteHotelById(Integer id) {
		Boolean b= false;
		try {
			entityManager.remove(findHotelById(id));
			b= true;
		}
		catch (Exception e){
			System.err.println("error");
			
		}
		return b;
	}

	@Override
	public Hotel findHotelById(Integer id) {
		return entityManager.find(Hotel.class, id);
	}

	@Override
	public Boolean updateHotel(Hotel hotel) {
		Boolean b= false;
		try {
			entityManager.merge(hotel);
			b= true;
		}
		catch (Exception e){
			System.err.println("error");
		}
		return b;
	}

	@Override
	public Boolean deleteHotel(Hotel hotel) {
		Boolean b= false;
		try {
			entityManager.remove(entityManager.merge(hotel));
			b= true;
			
		}
		catch (Exception e) {
			System.err.println("error");
		}
		return b;
	}
	

	@Override
	public List<Hotel> findAllHotels() {
	 String jpql = "select h from Hotel h";
	 Query query= entityManager.createQuery(jpql);
	 return query.getResultList();
	}

}
