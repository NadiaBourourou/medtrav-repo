package tests.BokingServices;

import delegates.BookingServicesDelegate;
import entities.Booking;
import entities.StateBooking;

public class TestAddBooking {

	public static void main(String[] args) {
		Booking booking1 = new Booking();

		StateBooking state = null;
		booking1.setState(state.CONFIRMED);

		BookingServicesDelegate.doAddBooking(booking1);

	}

}
