package mailing;

public class SendMail {

	public static void main(String[] args) {
		String message = Message.sms;

		String[] to = { "Nadia.Bourourou@esprit.tn", "Nadiabourourou@gmail.com" };

		if (EmailSender.sendEmail("medtrav.gtech@gmail.com", "pidevgtech",
				message, to))
			System.out.println("email sent successfully");
		else
			System.out.println("some error occured");

	}
}
