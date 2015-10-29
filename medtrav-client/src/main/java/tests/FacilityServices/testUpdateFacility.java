package tests.FacilityServices;

import delegates.HotelServicesDelegate;
import entities.Facility;
import entities.Hotel;
import entities.StateBooking;

public class testUpdateFacility {


	public static void main(String[] args) {
		Hotel facility = new Hotel();
		facility= HotelServicesDelegate.doFindHotelById(1);
		facility.setAddress("lac");
		HotelServicesDelegate.doUpdateHotel(facility);
		

	}
}
