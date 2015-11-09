package services.utilities;

import java.text.ParseException;


import javax.annotation.PostConstruct;
import javax.ejb.LocalBean;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import entities.FlightMatching;


/**
 * Session Bean implementation class PopulateDb
 */
@Singleton
@LocalBean
@Startup
public class PopulateDb {
	
	@PersistenceContext
	private EntityManager entityManager;


    public PopulateDb() { }
    
    @PostConstruct
	public void initDb() throws ParseException{

		
    FlightMatching flight1 = new FlightMatching("AF1785", "Lyon - Lyon-Saint-Exupéry (LYS)", "Djerba - Djerba–Zarzis International Airport (DJE)", "16-11-2015","17-11-2015","15:00:00", "17:35:00", "AIRFRANCE", 7, 160D);
    entityManager.merge(flight1);
    
    FlightMatching flight27 = new FlightMatching("TU441", "Lyon - Lyon-Saint-Exupéry (LYS)", "Djerba - Djerba–Zarzis International Airport (DJE)", "18-11-2015","22-11-2015", "05:35:00",  "09:30:00", "TUNISAIR", 3, 140D);
    entityManager.merge(flight27);
    
    FlightMatching flight28 = new FlightMatching("UG002", "Lyon - Lyon-Saint-Exupéry (LYS)", "Djerba - Djerba–Zarzis International Airport (DJE)", "25-11-2015","01-12-2015", "09:00:00",  "10:45:00", "TUNISAIR EXPRESS", 2, 110D);
    entityManager.merge(flight28);
    
    FlightMatching flight29 = new FlightMatching("BJ778", "Lyon - Lyon-Saint-Exupéry (LYS)", "Djerba - Djerba–Zarzis International Airport (DJE)", "25-11-2015","01-12-2015", "20:05:00",  "21:40:00", "NOUVEL AIR TUNISIE", 4, 120D);
    entityManager.merge(flight29);
   
  FlightMatching flight2 = new FlightMatching("TU847", "Bruxelles - Brussels Airport (BRU)", "Tunis - Tunis-Carthage International Airport (TUN)", "17-11-2015","18-11-2015", "05:35:00", "07:35:00", "TUNISAIR", 8, 190D);
    entityManager.merge(flight2);
    FlightMatching flight3 = new FlightMatching("BJ382", "Bordeaux - Bordeaux–Mérignac Airport (BOD)", "Monastir - Monastir Habib Bourguiba International Airport(MIR)", "18-11-2015", "19-11-2015", "07:30:00", "08:35:00", "NOUVEL AIR TUNISIE", 9, 140D);
    entityManager.merge(flight3);
    FlightMatching flight4 = new FlightMatching("8U451", "Tripoli - Tripoli International Airport (TIP)", "Djerba - Djerba–Zarzis International Airport (DJE)", "19-11-2015","20-11-2015", "08:15:00", "09:00:00", "AFRIQIYAH AIRWAYS", 10, 130D);
    entityManager.merge(flight4);
    
    FlightMatching flight5 = new FlightMatching("UZ151", "Abidjan - Port Bouet Airport (ABJ)", "Sfax - Sfax–Thyna International Airport (SFA)", "20-11-2015","21-11-2015", "09:20:00", "12:05:00", "BURAQ AIR", 4, 160D);
    entityManager.merge(flight5);
    FlightMatching flight6 = new FlightMatching("TU847", "Paris - Paris Charles-de-Gaulle (CDG)", "Tunis - Tunis-Carthage International Airport (TUN)", "21-11-2015","23-11-2015", "10:30:00", "12:55:00", "TRANSAVIA", 15, 190D);
    entityManager.merge(flight6);
    FlightMatching flight7 = new FlightMatching("BJ382", "Malte - Malta International Airport (MLA)", "Tunis - Tunis-Carthage International Airport (TUN)", "19-11-2015","20-11-2015", "11:40:00", "13:50:00", "AIR MALTA", 11, 140D);
    entityManager.merge(flight7);
    FlightMatching flight8 = new FlightMatching("8U451", "Casablanca - Mohammed V International Airport (CMN)", "Enfidha - Enfidha-Hammamet International Airport(NBE)", "23-11-2015","24-11-2015", "08:00:00",  "10:45:00", "ROYAL AIR MAROC", 7, 150D);
    entityManager.merge(flight8);
    
    FlightMatching flight9 = new FlightMatching("AZ867", "Rome - Leonardo da Vinci–Fiumicino Airport (FCO)", "Tunis - Tunis-Carthage International Airport (TUN)", "16-11-2015","22-11-2015", "04:20:00", "06:20:00", "AIRFRANCE", 7, 200D);
    entityManager.merge(flight9);
    FlightMatching flight10 = new FlightMatching("LH1323", "Francfort - Frankfurt Airport (FRA)", "Djerba - Djerba–Zarzis International Airport (DJE)", "25-11-2015","30-11-2015", "20:00:00", "22:35:00", "TUNISAIR", 8, 250D);
    entityManager.merge(flight10);
    FlightMatching flight11 = new FlightMatching("MS844", "Le Caire - Cairo International Airport (CAI)", "Tunis - Tunis-Carthage International Airport (TUN)", "18-11-2015", "23-11-2015","07:30:00", "09:05:00", "NOUVEL AIR TUNISIE", 9, 140D);
    entityManager.merge(flight11);
    FlightMatching flight12 = new FlightMatching("TK622", "Istanbul - Aéroport Istanbul Ataturk (IST)", "Tunis - Tunis-Carthage International Airport (TUN)", "25-11-2015","01-12-2015", "15:15:00",  "16:40:00", "AFRIQIYAH AIRWAYS", 10, 130D);
    entityManager.merge(flight12);
    
    FlightMatching flight13 = new FlightMatching("3V857", "Nice - Nice-Côte d'Azur (NCE)", "Monastir - Monastir Habib Bourguiba International Airport(MIR)", "17-11-2015","22-11-2015", "16:35:00", "18:55:00", "TUNISAIR", 8, 120D);
    entityManager.merge(flight13);
    FlightMatching flight14 = new FlightMatching("TJ118", "Marseille - Marseille Provence (MRS)", "Tunis - Tunis-Carthage International Airport (TUN)", "10-11-2015","19-11-2015", "17:00:00", "18:40:00", "NOUVEL AIR TUNISIE", 9, 110D);
    entityManager.merge(flight14);
    FlightMatching flight15 = new FlightMatching("AH4001", "Alger - Houari Boumediene Airport (ALG)", "Tunis - Tunis-Carthage International Airport (TUN)", "19-11-2015", "20-11-2015", "13:15:00", "14:35:00", "AFRIQIYAH AIRWAYS", 10, 100D);
    entityManager.merge(flight15);
    FlightMatching flight16 = new FlightMatching("TU796", "Berlin - Berlin Brandenburg Airport (BER)", "Djerba - Djerba–Zarzis International Airport (DJE)", "15-11-2015","22-11-2015", "07:45:00", "11:15:00", "TUNISAIR", 8, 250D);
    entityManager.merge(flight16);
    
    FlightMatching flight17 = new FlightMatching("TU416", "Dakar - Léopold Sédar Senghor International Airport (DKR)", "Tabarka - Tabarka–Ain Draham International Airport (TBJ)", "02-12-2015","04-12-2015", "21:20:00", "02:55:00", "TUNISAIR", 8, 200D);
    entityManager.merge(flight17);
    FlightMatching flight18 = new FlightMatching("BT430", "Londres - Aéroport de Londres Heathrow (LHR)", "Enfidha - Enfidha-Hammamet International Airport(NBE)", "27-11-2015",  "5-12-2015", "19:40:00","22:45:00", "NOUVEL AIR TUNISIE", 9, 300D);
    entityManager.merge(flight18);
    FlightMatching flight19 = new FlightMatching("TU606", "Madrid - Adolfo Suárez Madrid–Barajas Airport (MAD)", "Tunis - Tunis-Carthage International Airport (TUN)", "26-11-2015", "02-12-2015",  "16:00:00", "18:10:00", "AFRIQIYAH AIRWAYS", 10, 250D);
    entityManager.merge(flight19);
    FlightMatching flight20 = new FlightMatching("UG004", "Palerme - Falcone–Borsellino Airport (PMO)", "Djerba - Djerba–Zarzis International Airport (DJE)", "03-12-2015","09-12-2015", "14:45:00", "15:45:00",  "TUNISAIR", 8, 220D);
    entityManager.merge(flight20);
    
    FlightMatching flight21 = new FlightMatching("TU021", "Belgrade - Belgrade Nikola Tesla (BEG)", "Tunis - Tunis-Carthage International Airport (TUN)", "06-12-2015", "12-12-2015","11:00:00", "14:15:00", "TUNISAIR", 8, 300D);
    entityManager.merge(flight21);
    FlightMatching flight22 = new FlightMatching("TR159", "Sarajevo - Sarajevo International Airport (SJJ)", "Sfax - Sfax–Thyna International Airport (SFA)", "14-11-2015","21-11-2015", "06:00:00", "10:50:00", "TAROM", 8, 230D);//
    entityManager.merge(flight22);
    FlightMatching flight23 = new FlightMatching("TR601", "Bucarest  - Aéroport international Henri Coanda (OTP)", "Tunis - Tunis-Carthage International Airport (TUN)", "22-11-2015", "25-11-2015" ,"15:05:35:00", "20:30:00",  "RYANAIR", 8, 250D);
    entityManager.merge(flight23);
    FlightMatching flight24 = new FlightMatching("MEA777", "Beyrouth - Aéroport international de Beyrouth - Rafic Hariri", "Monastir - Monastir Habib Bourguiba International Airport(MIR)", "25-11-2015","02-12-2015", "17:15:00", "20:45:00",  "MIDDLE EAST AIRLINES", 8, 210D);
    entityManager.merge(flight24);
    
    FlightMatching flight25 = new FlightMatching("ZI898", "Paris - Paris Orly (ORY)", "Tunis - Tunis-Carthage International Airport (TUN)", "23-11-2015", "30-11-2015","12:00:00", "14:25:00",  "AIGLE AZUR", 8, 140D);
    entityManager.merge(flight25);
    FlightMatching flight26 = new FlightMatching("AF6423", "Toulouse - Toulouse Blagnac (TLS)", "Tunis - Tunis-Carthage International Airport (TUN)", "11-12-2015","19-12-2015", "18:30:00" ,"20:20:00", "AIRFRANCE", 8, 170D);
    entityManager.merge(flight26);
    
    /*FLIGHTS*/

    
    	}

}
