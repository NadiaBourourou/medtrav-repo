package services.interfaces;

import java.util.List;

import javax.ejb.Local;

import entities.Hotel;

@Local
public interface HotelServicesLocal {

	Boolean addHotel(Hotel hotel);

	Boolean deleteHotelById(Integer id);

	Hotel findHotelById(Integer id);

	Boolean updateHotel(Hotel hotel);

	Boolean deleteHotel(Hotel hotel);

	List<Hotel> findAllHotels();
}
