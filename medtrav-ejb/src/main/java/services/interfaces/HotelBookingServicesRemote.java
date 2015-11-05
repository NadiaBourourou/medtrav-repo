package services.interfaces;

import javax.ejb.Remote;

import entities.Hotel;
import entities.HotelBooking;

@Remote
public interface HotelBookingServicesRemote {

	Double calculPrix(Double prix, Double numNights);

	Boolean addHotelBooking(HotelBooking hb);

	Hotel findHotelByPatientId(Integer idPatient);
}
