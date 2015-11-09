package delegates;

import java.io.File;
import java.sql.Blob;
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
	public static Hotel doFindHotelByName(String name){
		
		return getProxy().findHotelByName(name);
	}
	
	public static List<Hotel> doFindAllHotelsEnabled () {
		return getProxy().findAllHotelsEnabled();
	}
	public static Double doCalculPrix(Double prix, Integer numNights) {
		return getProxy().calculPrix(prix, numNights);
	}

	public static boolean doAddHotelBooking (HotelBooking hb){
		return getProxy().addHotelBooking(hb);
	}
	

	public static Hotel doFindHotelByPatientId(Integer idPatient){
		return getProxy().findHotelByPatientId(idPatient);
	}
	
	public static Boolean doBookHotel(Integer numNights, Double price, RoomType roomType, Hotel hotel, Integer idPatient){
		return getProxy().bookHotel(numNights,price,roomType,hotel, idPatient);
	}
	

}
