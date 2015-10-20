package tests.FacilityServices;

import java.util.List;

import delegates.FacilityServicesDelegate;
import entities.Facility;

public class testFindAllFacilities {

	public static void main(String[] args) {

		List<Facility> facilities = FacilityServicesDelegate
				.doFindAllFacilities();

		System.out.println(facilities.size());
		for (Facility f : facilities) {
			System.out.println(f.getName());
		}
	}
}