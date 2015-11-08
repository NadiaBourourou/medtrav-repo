package services.interfaces;

import java.util.List;

import javax.ejb.Local;

import entities.Hotel;
import entities.HotelBooking;
import entities.RoomType;

@Local
public interface HotelServicesLocal {

	Boolean addHotel(Hotel hotel);

	Boolean deleteHotelById(Integer id);

	Hotel findHotelById(Integer id);

	Boolean updateHotel(Hotel hotel);

	Boolean deleteHotel(Hotel hotel);

	List<Hotel> findAllHotels();

	Double calculPrix(Double prix, Integer numNights);

	Boolean addHotelBooking(HotelBooking hb);

	Hotel findHotelByPatientId(Integer idPatient);
	
	Boolean bookHotel(Integer numNights, Double price, RoomType roomType, Hotel hotel, Integer idPatient);
}
