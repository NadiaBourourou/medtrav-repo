package services.interfaces;

import java.util.List;

import javax.ejb.Remote;

import entities.Booking;

@Remote
public interface BookingServicesRemote {

	Boolean addBooking(Booking booking);

	Boolean updateBooking(Booking booking);

	Boolean deleteBooking(Booking booking);

	List<Booking> findAllBookingsByPatient(Integer patientId);

	Booking findBookingById(Integer idBooking);

}
