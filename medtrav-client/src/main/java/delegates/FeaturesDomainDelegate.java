package delegates;

import locator.ServiceLocator;
import featuresDomain.mailing.EmailSendingRemote;

public class FeaturesDomainDelegate {
	public static final String jndiName = "/medtrav-ejb/EmailSending!featuresDomain.mailing.EmailSendingRemote";

	public static EmailSendingRemote getProxy() {
		return (EmailSendingRemote) ServiceLocator.getInstance().getProxy(
				jndiName);
	}

	public static boolean doSendEmail(String from, String password,
			String message, String to[]) {
		return getProxy().sendEmail(from, password, message, to);
	}

	public static String doWelcomingMail() {
		return getProxy().welcomingMail();
	}

	public static String doPatientLoginAndPassword(String login, String pwd)

	{
		return getProxy().patientLoginAndPassword(login, pwd);
	}

}
