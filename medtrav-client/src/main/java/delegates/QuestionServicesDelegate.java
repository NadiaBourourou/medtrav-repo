package delegates;

import java.util.List;

import locator.ServiceLocator;
import services.interfaces.QuestionServicesRemote;
import entities.Patient;
import entities.Question;
import entities.User;

public class QuestionServicesDelegate {
	
	public static final String jndiName = "/medtrav-ejb/QuestionServices!services.interfaces.QuestionServicesRemote";

	public static QuestionServicesRemote getProxy() {
		return (QuestionServicesRemote) ServiceLocator.getInstance().getProxy(
				jndiName);
	}

	public static void doAddQuestion(Question question) {
		getProxy().addQuestion(question);
	}

	public static void doUpdateQuestion(Question testimony) {
		getProxy().addQuestion(testimony);
	}

	public static Question doFindQuestionById(Integer idQuestion) {
		return getProxy().findQuestionById(idQuestion);
	}

	public static void doDeleteQuestion(Question testimony) {
		getProxy().deleteQuestion(testimony);
	}

	public static List<Question> doFindAllQuestionsByPatient(Integer patientId) {
		return getProxy().findAllQuestionsByPatientId(patientId);
	}

	public static Patient doFindPatientById(Integer idQuestion) {
		return getProxy().findPatientById(idQuestion);
	}
	
	
	public static List<Question> doFindAllQuestions() {
		return getProxy().findAllQuestions();
	}
	

}
