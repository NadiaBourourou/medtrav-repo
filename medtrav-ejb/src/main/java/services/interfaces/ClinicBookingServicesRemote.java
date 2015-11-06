package services.interfaces;

import javax.ejb.Remote;

import entities.Clinic;
import entities.ClinicBooking;
import entities.Hotel;
import entities.RoomClinicType;
import entities.RoomType;

@Remote
public interface ClinicBookingServicesRemote {

  Boolean addClinicBookingAndAffectClinic(ClinicBooking clinicBooking, Integer id);
  
	


Boolean bookClinic(RoomClinicType typeRoom, String date,
		String commentaire,  Clinic clinic, Integer idPatient);


}