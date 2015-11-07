package services.interfaces;

import java.util.List;

import javax.ejb.Remote;

import entities.Booking;
import entities.Clinic;
import entities.Doctor;
import entities.Hotel;
import entities.HotelBooking;
import entities.Surgery;

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

	Booking findBookingByPatientId(Integer idPatient);

	Boolean deleteBookingByPatientId(Integer idPatient);

	HotelBooking findHotelBookingByPatientId(Integer idPatient);

	Surgery findSurgeryByPatientId(Integer idPatient);

	Doctor findDoctorByPatientId(Integer idPatient);

}
