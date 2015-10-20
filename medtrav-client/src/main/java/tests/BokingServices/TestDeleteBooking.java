package tests.BokingServices;

import delegates.BookingServicesDelegate;
import entities.Booking;

public class TestDeleteBooking {

	public static void main(String[] args) {
		Booking booking = new Booking();
		booking = BookingServicesDelegate.doFindBookingById(3);
		BookingServicesDelegate.doDeleteBooking(booking);
	}
	

}
