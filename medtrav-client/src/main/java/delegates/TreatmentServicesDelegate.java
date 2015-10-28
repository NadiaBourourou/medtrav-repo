package delegates;

import java.util.List;

import locator.ServiceLocator;
import services.interfaces.TreatmentServicesRemote;
import entities.Procedure;
import entities.Treatment;

public class TreatmentServicesDelegate {

	private TreatmentServicesRemote remote;
	private static final String jndiName = "/medtrav-ejb/TreatmentServices!services.interfaces.TreatmentServicesRemote";

	private static TreatmentServicesRemote getProxy() {
		return (TreatmentServicesRemote) ServiceLocator.getInstance().getProxy(
				jndiName);
	}

	public static boolean doAddTreatment(Treatment treatment) {
		return getProxy().addTreatment(treatment);
	}

	public static boolean doAddProcedure(Procedure procedure) {
		return getProxy().addProcedure(procedure);
	}

	public static Boolean doAssignProcedureToTreatment(Treatment newTreatment,
			Integer procedureId) {
		return getProxy().assignProcedureToTreatment(newTreatment, procedureId);
	}

	public static List<Procedure> doFindAllProcedures() {
		return getProxy().findAllProcedures();
	}

	public static List<Treatment> doFindAllTreatmentsByProcedureId(
			Integer procedureId) {
		return getProxy().findAllTreatmentsByProcedureId(procedureId);
	}

	public static String doGetTreatmentDescription(Integer treatmentId) {
		return getProxy().getTreatmentDescription(treatmentId);
	}

}
