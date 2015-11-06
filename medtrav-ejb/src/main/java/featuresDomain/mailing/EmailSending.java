package featuresDomain.mailing;

import java.util.Properties;

import javax.ejb.Stateless;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 * Session Bean implementation class EmailSending
 */
@Stateless
public class EmailSending implements EmailSendingRemote {

	/**
	 * Default constructor.
	 */
	public EmailSending() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean sendEmail(String from, String password, String message,
			String[] to) {
		String host = "smtp.gmail.com";
		Properties props = System.getProperties();
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", host);
		props.put("mail.smtp.user", from);
		props.put("mail.smtp.password", password);
		props.put("mail.smtp.port", 587);
		props.put("mail.smtp.auth", "true");
		Session session = Session.getDefaultInstance(props, null);
		MimeMessage mimeMessage = new MimeMessage(session);
		try {
			mimeMessage.setFrom(new InternetAddress(from));
			InternetAddress[] toAddress = new InternetAddress[to.length];
			for (int i = 0; i < to.length; i++) {
				toAddress[i] = new InternetAddress(to[i]);
			}
			for (int i = 0; i < toAddress.length; i++) {
				mimeMessage
						.addRecipient(Message.RecipientType.TO, toAddress[i]);
			}
			mimeMessage.setSubject("Welcome to MedTrav");
			mimeMessage.setContent(message, "text/html");
			Transport transport = session.getTransport("smtp");
			transport.connect(host, from, password);
			transport.sendMessage(mimeMessage, mimeMessage.getAllRecipients());
			transport.close();
			return true;

		} catch (MessagingException me) {
			me.printStackTrace();
		}

		return false;
	}

	@Override
	public String welcomingMail() {
		return "<img src='http://img15.hostingpics.net/pics/187393Capture2.png' width:100% />"
				+ "";
	}
}
