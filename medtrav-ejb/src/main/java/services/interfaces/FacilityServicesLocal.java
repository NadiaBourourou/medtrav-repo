package services.interfaces;

import java.util.List;

import javax.ejb.Local;

import entities.Facility;

@Local
public interface FacilityServicesLocal {

	Boolean addFacility(Facility Facility);

	Boolean deleteFacilityById(Integer id);

	Facility findFacilityById(Integer id);

	Boolean updateFacility(Facility Facility);

	Boolean deleteFacility(Facility Facility);

	List<Facility> findAllFacilities();
}
