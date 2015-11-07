package services.impl;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import entities.Clinic;
import entities.ClinicBooking;
import entities.HotelBooking;
import entities.Patient;
import entities.RoomClinicType;
import services.interfaces.ClinicBookingServicesLocal;
import services.interfaces.ClinicBookingServicesRemote;

/**
 * Session Bean implementation class ClinicBookingServices
 */
@Stateless
public class ClinicBookingServices implements ClinicBookingServicesRemote, ClinicBookingServicesLocal {
@PersistenceContext
EntityManager entityManager;
    /**
     * Default constructor. 
     */
    public ClinicBookingServices() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public Boolean addClinicBookingAndAffectClinic(ClinicBooking clinicBooking,
			Integer id) {
		Boolean b= false;
	
		try {
	 Clinic clinic = entityManager.find(Clinic.class, id);

	 clinicBooking.setClinic(clinic);
	 entityManager.merge(clinicBooking);
	 b= true;
		}
		catch (Exception e) {
			System.err.println("error");
		}
		return b;
	 
	 
	 
	}

	@Override
	public Boolean bookClinic(RoomClinicType typeRoom, String date,
			String commentaire, Clinic clinic, Integer idPatient) {
		Boolean b = false;
		try {
			Patient patient= entityManager.find(Patient.class,idPatient);
			ClinicBooking clinicBooking = new ClinicBooking(typeRoom, date,
				commentaire, clinic, patient);
			entityManager.merge(clinicBooking);
			b = true;
		} catch (Exception e) {
		}
		return b;
	}
	}


