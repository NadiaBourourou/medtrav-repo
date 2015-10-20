package delegates;

import java.util.List;

import locator.ServiceLocator;
import services.interfaces.FacilityServicesRemote;
import entities.Facility;

public class FacilityServicesDelegate {
	private FacilityServicesRemote remote;
	private static final String jndiName = "/medtrav-ejb/FacilityServices!services.interfaces.FacilityServicesRemote";

	private static FacilityServicesRemote getProxy() {
		return (FacilityServicesRemote) ServiceLocator.getInstance().getProxy(
				jndiName);
	}

	public static boolean doAddFacility(Facility Facility) {
		return getProxy().addFacility(Facility);
	}

	public static boolean doUpdateFacility(Facility Facility) {
		return getProxy().updateFacility(Facility);
	}

	public static boolean doDeleteFacilityById(Integer FacilityId) {
		return getProxy().deleteFacilityById(FacilityId);
	}
	public static boolean doDeleteFacilityById(Facility facility) {
		return getProxy().deleteFacility(facility);
	}

	public static Facility doFindFacilityById(Integer id) {
		return getProxy().findFacilityById(id);
	}

	public static List<Facility> doFindAllFacilities() {
		return getProxy().findAllFacilities();
	}

}

