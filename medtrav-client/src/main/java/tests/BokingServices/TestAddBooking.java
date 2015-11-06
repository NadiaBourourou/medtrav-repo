package tests.BokingServices;

import java.util.Date;

import delegates.BookingServicesDelegate;
import entities.Booking;
import entities.Patient;
import entities.StateBooking;
import entities.Surgery;
import entities.SurgeryPatient;
import entities.SurgeryPatientID;

public class TestAddBooking {

	public static void main(String[] args) {
		Booking booking1 = new Booking();
		booking1.setArrival(new Date());
		booking1.setDeparture(new Date());
		StateBooking state = null;
		booking1.setState(state.CONFIRMED);
		SurgeryPatient sp = new SurgeryPatient();
		Patient p = new Patient();
		p.setUserId(1);
		Surgery s = new Surgery();
		s.setSurgeryId(1);
		sp.setPatient(p);
		sp.setSurgery(s);
		SurgeryPatientID ids = new SurgeryPatientID();
		ids.setIdPatient(p.getUserId());
		ids.setIdSurgery(s.getSurgeryId());
		sp.setSurgeryPatientID(ids);
		booking1.setSurgeryPatient(sp);

		BookingServicesDelegate.doAddBooking(booking1);

	}

}
