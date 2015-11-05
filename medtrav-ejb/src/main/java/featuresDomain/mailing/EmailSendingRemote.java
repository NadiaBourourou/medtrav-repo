package featuresDomain.mailing;

import javax.ejb.Remote;

@Remote
public interface EmailSendingRemote {
	public boolean sendEmail(String from, String password,
			String message, String to[]);

	
	
	public String welcomingMail();
}
