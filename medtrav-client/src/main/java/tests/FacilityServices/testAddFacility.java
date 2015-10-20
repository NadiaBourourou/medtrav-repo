package tests.FacilityServices;

import delegates.FacilityServicesDelegate;
import entities.Facility;
import entities.RoomType;
import entities.StateType;

public class testAddFacility {

	public static void main(String[] args) {
		Facility facility = new Facility();
		facility.setName("marsa");
		facility.setDescription("good");
		facility.setAddress("marsa");
		facility.setNumNights(3);
		facility.setPrice(2D);
		StateType state = null;
		facility.setState(state.ENABLED);
		RoomType state2 = null;
		facility.setRoom(state2.SINGLE);

		FacilityServicesDelegate.doAddFacility(facility);
	}
}