package delegates;

import java.util.Date;
import java.util.List;

import locator.ServiceLocator;
import services.interfaces.HotelServicesRemote;
import entities.Hotel;
import entities.HotelBooking;
import entities.RoomType;

public class HotelServicesDelegate {
	private HotelServicesRemote remote;
	private static final String jndiName = "/medtrav-ejb/HotelServices!services.interfaces.HotelServicesRemote";

	private static HotelServicesRemote getProxy() {
		return (HotelServicesRemote) ServiceLocator.getInstance().getProxy(
				jndiName);
	}

	public static boolean doAddHotel(Hotel hotel) {
		return getProxy().addHotel(hotel);
	}

	public static boolean doUpdateHotel(Hotel hotel) {
		return getProxy().updateHotel(hotel);
	}

	public static boolean doDeleteHotelById(Integer HotelId) {
		return getProxy().deleteHotelById(HotelId);
	}

	public static boolean doDeleteHotel(Hotel hotel) {
		return getProxy().deleteHotel(hotel);
	}

	public static Hotel doFindHotelById(Integer id) {
		return getProxy().findHotelById(id);
	}

	public static List<Hotel> doFindAllHotels() {
		return getProxy().findAllHotels();
	}

	public static List<Hotel> doFindHotelByName(String name) {

		return getProxy().findHotelByName(name);
	}

	public static Double doCalculPrix(Double prix, Integer numNights) {
		return getProxy().calculPrix(prix, numNights);
	}

	public static boolean doAddHotelBooking(HotelBooking hotelBooking) {
		return getProxy().addHotelBooking(hotelBooking);
	}

	public static Hotel doFindHotelByPatientId(Integer idPatient) {
		return getProxy().findHotelByPatientId(idPatient);
	}

	public static Boolean doBookHotel(Integer numNights, Double price,
			RoomType roomType, Date date, Hotel hotel, Integer idPatient) {
		return getProxy().bookHotel(numNights, price, roomType, date, hotel,
				idPatient);
	}

	public static List<Hotel> doFindHotelsByStars(Integer stars) {
		return getProxy().findHotelsByStars(stars);
	}

}
