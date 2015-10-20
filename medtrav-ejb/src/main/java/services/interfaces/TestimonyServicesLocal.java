package services.interfaces;

import java.util.List;

import javax.ejb.Local;

import entities.Testimony;

@Local
public interface TestimonyServicesLocal {

	Boolean addTestimony(Testimony testimony);

	Boolean updateTestimony(Testimony testimony);

	Boolean deleteTestimony(Testimony testimony);

	List<Testimony> findAllTestimoniesByPatientId(Integer patientId);

	Testimony findTestimonyById(Integer idTestimony);

}
