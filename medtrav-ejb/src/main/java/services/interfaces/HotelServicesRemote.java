package services.interfaces;

import java.util.List;

import javax.ejb.Remote;

import entities.Hotel;

@Remote
public interface HotelServicesRemote {

	Boolean addHotel(Hotel hotel);

	Boolean deleteHotelById(Integer id);

	Hotel findHotelById(Integer id);
	Hotel findHotelByName(String name);

	Boolean updateHotel(Hotel hotel);

	Boolean deleteHotel(Hotel hotel);

	List<Hotel> findAllHotels();
	
}
