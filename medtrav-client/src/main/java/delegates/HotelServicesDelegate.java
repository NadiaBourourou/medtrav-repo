package delegates;

import java.util.List;

import locator.ServiceLocator;

import services.interfaces.HotelServicesRemote;

import entities.Hotel;

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

	public static boolean doDeleteHotelById(Hotel hotel) {
		return getProxy().deleteHotel(hotel);
	}

	public static Hotel doFindHotelById(Integer id) {
		return getProxy().findHotelById(id);
	}

	public static List<Hotel> doFindAllHotels() {
		return getProxy().findAllHotels();
	}

}
