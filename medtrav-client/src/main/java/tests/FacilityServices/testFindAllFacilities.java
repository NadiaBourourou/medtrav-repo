package tests.FacilityServices;

import java.util.List;

import delegates.HotelServicesDelegate;
import entities.Facility;
import entities.Hotel;

public class testFindAllFacilities {

	public static void main(String[] args) {

		List<Hotel> facilities = HotelServicesDelegate
				.doFindAllHotels();

		System.out.println(facilities.size());
		for (Hotel f : facilities) {
			System.out.println(f.getName());
		}
	}
}