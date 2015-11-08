package delegates;

import java.util.List;

import locator.ServiceLocator;
import services.interfaces.BookingServicesRemote;
import entities.Booking;
import entities.Clinic;
import entities.ClinicBooking;
import entities.DoctorPatient;
import entities.Flight;
import entities.Hotel;
import entities.HotelBooking;
import entities.Surgery;
import entities.SurgeryPatient;

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

	public static void doDeleteBookingByPatientId(Booking booking) {
		getProxy().deleteBookingByPatientId(booking);
	}

	public static Booking doFindBookingByPatientId(Integer idPatient) {
		return getProxy().findBookingByPatientId(idPatient);
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

	public static Surgery doFindSurgeryByPatientId(Integer idPatient) {
		return getProxy().findSurgeryByPatientId(idPatient);
	}

	public static HotelBooking doFindHotelBookingByPatientId(Integer idPatient) {
		return getProxy().findHotelBookingByPatientId(idPatient);
	}

	public static ClinicBooking doFindClinicBookingByPatientId(Integer idPatient) {
		return getProxy().findClinicBookingByPatientId(idPatient);
	}

	public static SurgeryPatient doFindSurgeryPatientByPatientId(
			Integer idPatient) {
		return getProxy().findSurgeryPatientByPatientId(idPatient);
	}

	public static DoctorPatient doFindDoctorPatientByPatientId(Integer idPatient) {
		return getProxy().findDoctorPatientByPatientId(idPatient);
	}

	public static Flight doFindFlightByPatientId(Integer idPatient) {
		return getProxy().findFlightByPatientId(idPatient);
	}
}
