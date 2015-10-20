package services.interfaces;

import java.util.List;

import javax.ejb.Remote;

import entities.Facility;

@Remote
public interface FacilityServicesRemote {
	Boolean addFacility(Facility Facility);

	Boolean deleteFacilityById(Integer id);

	Facility findFacilityById(Integer id);

	Boolean updateFacility(Facility Facility);

	Boolean deleteFacility(Facility Facility);

	List<Facility> findAllFacilities();


}
