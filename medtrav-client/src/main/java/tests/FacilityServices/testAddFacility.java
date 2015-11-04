package tests.FacilityServices;

import entities.Hotel;
import entities.RoomType;
import entities.StateType;

public class testAddFacility {

	public static void main(String[] args) {
		Hotel facility = new Hotel();
		facility.setName("marsa");
		facility.setDescription("good");
		facility.setAddress("marsa");
		facility.setNumNights(3);

		StateType state = null;
		facility.setState(state.ENABLED);
		RoomType state2 = null;
		facility.setRoom(state2.SINGLE);

		
		Facility facility2 = new Facility();
		facility2.setName("Cli");
		facility2.setDescription("nice");
		facility2.setAddress("Menzah");
		facility2.setNumNights(3);
		facility2.setPrice(2D);
		StateType state3 = null;
		facility2.setState(state.ENABLED);
		RoomType state4 = null;
		facility2.setRoom(state2.SUITE);

	}
}