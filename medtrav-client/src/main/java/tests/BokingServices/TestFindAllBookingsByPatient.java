package tests.BokingServices;

import delegates.BookingServicesDelegate;
import entities.Patient;

public class TestFindAllBookingsByPatient {

	public static void main(String[] args) {

		Patient patient = new Patient();

		patient.setUserId(1);
		System.out.println(BookingServicesDelegate
				.doFindAllBookingsByPatient(1));

	}

}
