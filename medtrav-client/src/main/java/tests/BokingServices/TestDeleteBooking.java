package tests.BokingServices;

import delegates.BookingServicesDelegate;
import entities.Booking;

public class TestDeleteBooking {

	public static void main(String[] args) {
		Booking booking = new Booking();
		booking = BookingServicesDelegate.doFindBookingByPatientId(1);
		System.out.println(booking.getBookingId());
		BookingServicesDelegate.doDeleteBookingByPatientId(booking);
		System.out.println(0);
	}
	

}
