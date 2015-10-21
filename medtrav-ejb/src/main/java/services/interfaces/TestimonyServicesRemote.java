package services.interfaces;

import java.util.List;

import javax.ejb.Remote;
import javax.persistence.Query;

import entities.Booking;
import entities.Testimony;

@Remote
public interface TestimonyServicesRemote {

	
	Boolean addTestimony(Testimony testimony);

	Boolean updateTestimony(Testimony testimony);

	 Boolean deleteTestimony(Testimony testimony);
	
	 List<Testimony> findAllTestimoniesByPatientId(Integer patientId);

	
	 Testimony findTestimonyById(Integer idTestimony);
	
}