package delegates;

import featuresDomain.mailing.EmailSendingRemote;
import locator.ServiceLocator;

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
	
	

}
