package tests.BokingServices;

import delegates.BookingServicesDelegate;
import entities.Booking;
import entities.Hotel;
import entities.HotelBooking;
import entities.Patient;
import entities.StateBooking;

public class TestAddBooking {

	public static void main(String[] args) {
		Booking booking1 = new Booking();

		StateBooking state = null;
		booking1.setState(state.CONFIRMED);
		HotelBooking hotelBooking = new HotelBooking();
		Patient p = new Patient();
		p.setUserId(1);
		hotelBooking.setPatient(p);
		Hotel hotel = new Hotel();
		hotel.setHotelId(1);
		hotelBooking.setHotel(hotel);
		booking1.setHotelBooking(hotelBooking);

		BookingServicesDelegate.doAddBooking(booking1);

	}

}
