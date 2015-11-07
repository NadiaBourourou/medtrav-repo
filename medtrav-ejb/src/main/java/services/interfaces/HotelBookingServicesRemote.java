package services.interfaces;

import java.util.List;

import javax.ejb.Remote;

import entities.Hotel;
import entities.HotelBooking;
import entities.RoomType;

@Remote
public interface HotelBookingServicesRemote {

	Double calculPrix(Double prix, Integer numNights);

	Boolean addHotelBooking(HotelBooking hb);

	Hotel findHotelByPatientId(Integer idPatient);
	
	Boolean bookHotel(Integer numNights, Double price, RoomType roomType, Hotel hotel, Integer idPatient);
	
}
