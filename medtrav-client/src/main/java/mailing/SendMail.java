package mailing;

import javax.activation.FileDataSource;

import delegates.FeaturesDomainDelegate;



public class SendMail {

	public static void main(String[] args) {
		
		
		String message = FeaturesDomainDelegate.doWelcomingMail();

		String[] to = { "Nadia.Bourourou@esprit.tn", "Nadiabourourou@gmail.com" };

		if (FeaturesDomainDelegate.doSendEmail("medtrav.gtech@gmail.com", "pidevgtech",
				message, to))
			System.out.println("email sent successfully");
		else
			System.out.println("some error occured");

	}
}
