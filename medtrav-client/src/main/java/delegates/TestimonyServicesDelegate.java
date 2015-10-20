package delegates;

import java.util.List;

import locator.ServiceLocator;
import services.interfaces.TestimonyServicesRemote;
import entities.Testimony;

public class TestimonyServicesDelegate {

	public static final String jndiName = "/medtrav-ejb/TestimonyServices!services.interfaces.TestimonyServicesRemote";

	public static TestimonyServicesRemote getProxy() {
		return (TestimonyServicesRemote) ServiceLocator.getInstance().getProxy(
				jndiName);
	}

	public static void doAddTestimony(Testimony testimony) {
		getProxy().addTestimony(testimony);
	}

	public static void doUpdateTestimony(Testimony testimony) {
		getProxy().addTestimony(testimony);
	}

	public static Testimony doFindTestimonyById(Integer idTestimony) {
		return getProxy().findTestimonyById(idTestimony);
	}

	public static void doDeleteTestimony(Testimony testimony) {
		getProxy().deleteTestimony(testimony);
	}

	public static List<Testimony> doFindAllTestimoniesByPatient(Integer patientId) {
		return getProxy().findAllTestimoniesByPatientId(patientId);
	}

	
}
