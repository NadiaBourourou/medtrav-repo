package tests.BokingServices;

import delegates.BookingServicesDelegate;
import entities.Booking;
import entities.StateBooking;

public class TestUpdateBooking {

	public static void main(String[] args) {
		Booking booking = new Booking();
		StateBooking stateBooking = null;
		booking= BookingServicesDelegate.doFindBookingById(3);
		booking.setState(stateBooking.CANCELED);
		BookingServicesDelegate.doUpdateBooking(booking);
		

	}
}
