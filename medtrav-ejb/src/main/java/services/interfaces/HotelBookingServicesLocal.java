package services.interfaces;

import javax.ejb.Local;

import entities.Hotel;

@Local
public interface HotelBookingServicesLocal {

	Double calculPrix(Double prix, Integer numNights);
}
