package delegates;

import java.util.List;

import locator.ServiceLocator;
import services.interfaces.SurgeryServicesRemote;
import entities.Procedure;
import entities.Surgery;

public class SurgeryServicesDelegate {

	private SurgeryServicesRemote remote;
	private static final String jndiName = "/medtrav-ejb/SurgeryServices!services.interfaces.SurgeryServicesRemote";

	private static SurgeryServicesRemote getProxy() {
		return (SurgeryServicesRemote) ServiceLocator.getInstance().getProxy(
				jndiName);
	}

	public static boolean doAddSurgery(Surgery treatment) {
		return getProxy().addSurgery(treatment);
	}

	public static boolean doAddProcedure(Procedure procedure) {
		return getProxy().addProcedure(procedure);
	}

	public static Boolean doAssignProcedureToSurgery(Surgery newTreatment,
			Integer procedureId) {
		return getProxy().assignProcedureToSurgery(newTreatment, procedureId);
	}

	public static List<Procedure> doFindAllProcedures() {
		return getProxy().findAllProcedures();
	}

	public static List<Surgery> doFindAllTreatmentsByProcedureId(
			Integer procedureId) {
		return getProxy().findAllSurgeriesByProcedureId(procedureId);
	}

	public static String doGetSurgeryDescription(Integer treatmentId) {
		return getProxy().getSurgeryDescription(treatmentId);
	}

	public static void doAddTreatmentAndAssignItToProcedure(Surgery treatment,
			Integer idProcedure) {
		getProxy().addSurgeryAndAssignItToProcedure(treatment, idProcedure);
	}

	public static Surgery doFindSurgeryById(Integer idSurgery) {
		return getProxy().findSurgeryById(idSurgery);
	}

	public static List<Surgery> doFindAllSurgeriesByDoctorId(Integer idDoctor) {
		return getProxy().findAllSurgeriesByDoctorId(idDoctor);
	}

	public static List<Surgery> doFindAllSurgeriesByMedicalRecordsId(
			Integer idMedicalRecord) {
		return getProxy().findAllSurgeriesByMedicalRecordsId(idMedicalRecord);
	}

}
