package delegates;

import java.util.List;

import locator.ServiceLocator;
import services.interfaces.BookingServicesRemote;
import entities.Booking;
import entities.Clinic;
import entities.Hotel;

public class BookingServicesDelegate {
	public static final String jndiName = "/medtrav-ejb/BookingServices!services.interfaces.BookingServicesRemote";

	public static BookingServicesRemote getProxy() {
		return (BookingServicesRemote) ServiceLocator.getInstance().getProxy(
				jndiName);
	}

	public static void doAddBooking(Booking booking) {
		getProxy().addBooking(booking);
	}

	public static void doUpdateBooking(Booking booking) {
		getProxy().addBooking(booking);
	}

	public static Booking doFindBookingById(Integer idBooking) {
		return getProxy().findBookingById(idBooking);
	}

	public static void doDeleteBooking(Booking booking) {
		getProxy().deleteBooking(booking);
	}

	public static List<Booking> doFindAllBookingsByPatient(Integer patientId) {
		return getProxy().findAllBookingsByPatient(patientId);
	}

	public static Hotel doFindHotelByPatientId(Integer idPatient) {
		return getProxy().findHotelByPatientId(idPatient);
	}

	public static Clinic doFindClinicByPatientId(Integer idPatient) {
		return getProxy().findClinicByPatientId(idPatient);
	}
}
