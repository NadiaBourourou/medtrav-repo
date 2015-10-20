package tests.FacilityServices;

import delegates.FacilityServicesDelegate;
import entities.Facility;
import entities.StateBooking;

public class testUpdateFacility {


	public static void main(String[] args) {
		Facility facility = new Facility();
		facility= FacilityServicesDelegate.doFindFacilityById(1);
		facility.setAddress("lac");
		FacilityServicesDelegate.doUpdateFacility(facility);
		

	}
}
