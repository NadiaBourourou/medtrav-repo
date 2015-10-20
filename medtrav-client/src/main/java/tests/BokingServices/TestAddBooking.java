package tests.BokingServices;

import java.util.Date;

import delegates.BookingServicesDelegate;
import entities.Booking;
import entities.StateBooking;

public class TestAddBooking {

	public static void main(String[] args) {
		Booking booking1 = new Booking();
		booking1.setArrival(new Date());
		booking1.setDeparture(new Date());
		StateBooking state = null;
		booking1.setState(state.CONFIRMED);

		BookingServicesDelegate.doAddBooking(booking1);

	}

}
