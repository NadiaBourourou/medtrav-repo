package delegates;

import java.util.List;

import entities.Procedure;
import locator.ServiceLocator;
import services.interfaces.ProcedureServicesRemote;


public class ProcedureServicesDelegate {
	private ProcedureServicesRemote remote;
	private static final String jndiName = "/medtrav-ejb/ProcedureServices!services.interfaces.ProcedureServicesRemote";

	private static ProcedureServicesRemote getProxy() {
		return (ProcedureServicesRemote) ServiceLocator.getInstance().getProxy(
				jndiName);
	}

	public static Boolean doAddProcedure(Procedure procedure) {
		return getProxy().addProcedure(procedure);
	}
	
	public static List<Procedure> doFindAllProcedures(){
		return getProxy().findAllProcedures();
	}
	
	public static Boolean doUpdateProcedure(Procedure procedure){
		return getProxy().updateProcedure(procedure);
	}
	
	public static Boolean doDeleteProcedure(Procedure procedure){
		return getProxy().deleteProcedure(procedure);
	}
}
