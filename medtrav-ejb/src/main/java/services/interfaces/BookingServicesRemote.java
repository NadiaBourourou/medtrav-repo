package services.interfaces;

import java.util.List;

import javax.ejb.Remote;

import entities.Booking;
import entities.Clinic;
import entities.Hotel;

@Remote
public interface BookingServicesRemote {

	Boolean addBooking(Booking booking);

	Boolean updateBooking(Booking booking);

	Boolean deleteBooking(Booking booking);

	List<Booking> findAllBookingsByPatient(Integer patientId);

	Booking findBookingById(Integer idBooking);

	List<Booking> findAllBookingsByFlightId(Integer id);

	Hotel findHotelByPatientId(Integer idPatient);

	Clinic findClinicByPatientId(Integer idPatient);

}
