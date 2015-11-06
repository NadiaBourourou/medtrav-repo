package delegates;

import java.util.List;

import locator.ServiceLocator;
import services.interfaces.ServiceHotelServicesRemote;
import entities.ServiceHotel;

public class ServiceHotelServicesDelegate {

	private static final String jndiName = "/medtrav-ejb/ServiceHotelServices!services.interfaces.ServiceHotelServicesRemote";

	private static ServiceHotelServicesRemote getProxy() {
		return (ServiceHotelServicesRemote) ServiceLocator.getInstance().getProxy(
				jndiName);
	}

	public static Boolean doAddServiceHotel(ServiceHotel hotelService) {
		return getProxy().addServiceHotel(hotelService);
	}

	public static void doAssignServiceHotelToHotel(ServiceHotel serviceHotel, Integer id){
	    getProxy().assignServiceHotelToHotel(serviceHotel, id);
	}
	
	public static List<ServiceHotel> doFindAllServicesHotelByHotel(Integer id){
		return getProxy().findAllServicesHotelByHotel(id);
	}
	public static List<ServiceHotel> doFindAllServicesHotel(){
		return getProxy().findAllServicesHotel();
	}
	
	public static Boolean doUpdateServiceHotel(ServiceHotel serviceHotel){
		return getProxy().updateServiceHotel(serviceHotel);
	}
	
	public static Boolean doDeleteServiceHotel(ServiceHotel serviceHotel){
		return getProxy().deleteServiceHotel(serviceHotel);
	}
}
