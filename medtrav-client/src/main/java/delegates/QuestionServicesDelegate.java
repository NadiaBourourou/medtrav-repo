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

	public static List<Question> doFindAllQuestionsByPatientName(String name) {
		return getProxy().findAllQuestionsByPatientLastName(name);
	}
	public static List<Question> doFindAllQuestionsByTitle(String title) {
		return getProxy().findAllQuestionsByTitle(title);
	}
	public static List<Question> doFindAllQuestionsWithResponse() {
		return getProxy().findAllQuestionsWithResponse();
	}
	
	public static List<Question> doFindAllQuestionsNoResponse() {
		return getProxy().findAllQuestionsNoResponse();
	}
	
	public static List<Question> doFindAllQuestionsWithResponseAndTitle(String title) {
		return getProxy().findAllQuestionsWithResponseAndTitle(title);
	}

	public static List<Question> doFindAllQuestionsWithResponseAndPatient(String name) {
		return getProxy().findAllQuestionsWithResponseAndPatient(name);
	}
	public static List<Question> doFindAllQuestionsNoResponseAndTitle(String title) {
		return getProxy().findAllQuestionsNoResponseAndTitle(title);
	}
	public static List<Question> doFindAllQuestionsNoResponseAndPatient(String name) {
		return getProxy().findAllQuestionsNoResponseAndPatient(name);
	}
	
	public static Patient doFindPatientById(Integer idQuestion) {
		return getProxy().findPatientById(idQuestion);
	}
	
	
	public static List<Question> doFindAllQuestions() {
		return getProxy().findAllQuestions();
	}
	

}
