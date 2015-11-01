package services.impl;

import java.sql.Date;

import javax.ejb.LocalBean;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import entities.Doctor;
import entities.FlightMatching;
import entities.Patient;

/**
 * Session Bean implementation class PopulateDb
 */
@Singleton
@LocalBean
@Startup
public class PopulateDb {
	
	
	/// FORGOT HOW THIS IS SUPPOSED TO WORK !! 
	/// see Populate Db in client application for now

    public PopulateDb() {

    Patient patient1=new Patient();
    patient1.setFirstName("Flen");
    patient1.setLastName("Foulen");
    patient1.setCin(14714750);
    patient1.setCountry("Spain");
    patient1.setDateOfBirth(Date.valueOf("1993-12-02"));
    patient1.setLogin("Flen.Foulen");
    patient1.setPassword("pwdFlen");
    patient1.setMail("flenfoulen@gmail.com");
    patient1.setNumPassport(96359);
    

    Patient patient2=new Patient();
    patient2.setFirstName("Sam");
    patient2.setLastName("Heinrich");
    patient2.setCin(1000634);
    patient2.setCountry("Germay");
    patient2.setDateOfBirth(Date.valueOf("1984-6-12"));
    patient2.setLogin("Sam.Heinrich");
    patient2.setPassword("pwdSam");
    patient2.setMail("SamHeinrich@gmail.com");
    patient2.setNumPassport(121214);
    
    
    
    
   // Patient patient3=new Patient();
    // Patient patient4=new Patient();
    
    Doctor doctor1=new Doctor();
    doctor1.setFirstName("Max");
    doctor1.setLastName("Hunter");
    doctor1.setCin(1940634);
    doctor1.setDescription("Specialiste des maladies cardio-vasculaires");
    doctor1.setLogin("max.hunter");
    doctor1.setPassword("pwdMax");
    doctor1.setMail("MaxHunter@gmail.com"); 
    doctor1.setSpecialty("CardioVasculaire");
  
    

    
    
//    Doctor doctor2=new Doctor();
//    Doctor doctor3=new Doctor();

    /**********************************FLIGHTS********************************************/
  
    FlightMatching flight1 = new FlightMatching("AF1785", "Lyon - Lyon-Saint-Exupéry (LYS)", "Djerba (DJE)", "16-11-2015 01:20:00", "AIRFRANCE", 7);
    FlightMatching flight2 = new FlightMatching("TU847", "Bruxelles - Brussels Airport (BRU)", "Tunis Carthage (TUN)", "17-11-2015 05:35:00", "TUNISAIR", 8);
    FlightMatching flight3 = new FlightMatching("BJ382", "Bordeaux - Bordeaux–Mérignac Airport (BOD)", "Monastir (MIR)", "18-11-2015 07:30:00", "NOUVEL AIR TUNISIE", 9);
    FlightMatching flight4 = new FlightMatching("8U451", "Tripoli - Tripoli International Airport (TIP)", "Djerba (DJE)", "19-11-2015 08:15:00", "AFRIQIYAH AIRWAYS", 10);

    FlightMatching flight5 = new FlightMatching("UZ151", "Abidjan - Port Bouet Airport (ABJ)", "Sfax El Maou (SFA)", "20-11-2015 09:20:00", "BURAQ AIR", 4);
    FlightMatching flight6 = new FlightMatching("TU847", "Paris - Paris Charles-de-Gaulle (CDG)", "Tunis Carthage (TUN)", "21-11-2015 10:30:00", "TRANSAVIA", 15);
    FlightMatching flight7 = new FlightMatching("BJ382", "Malte - Malta International Airport (MLA)", "Tunis Carthage (TUN)", "19-11-2015 11:40:00", "AIR MALTA", 11);
    FlightMatching flight8 = new FlightMatching("8U451", "Casablanca - Mohammed V International Airport (CMN)", "Enfidha (NBE)", "23-11-2015 12:3:00", "ROYAL AIR MAROC", 7);
  
    FlightMatching flight9 = new FlightMatching("AZ867", "Rome - Leonardo da Vinci–Fiumicino Airport (FCO)", "Tunis Carthage (TUN)", "16-11-2015 01:20:00", "AIRFRANCE", 7);
    FlightMatching flight10 = new FlightMatching("LH1323", "Francfort - Frankfurt Airport (FRA)", "Djerba (DJE)", "17-11-2015 05:35:00", "TUNISAIR", 8);
    FlightMatching flight11 = new FlightMatching("MS844", "Le Caire - Cairo International Airport (CAI)", "Tunis Carthage (TUN)", "18-11-2015 07:30:00", "NOUVEL AIR TUNISIE", 9);
    FlightMatching flight12 = new FlightMatching("TK622", "Istanbul - Aéroport Istanbul Ataturk (IST)", "Tunis Carthage (TUN)", "19-11-2015 08:15:00", "AFRIQIYAH AIRWAYS", 10);
  
    FlightMatching flight13 = new FlightMatching("3V857", "Nice - Nice-Côte d'Azur (NCE)", "Monastir (MIR)", "17-11-2015 05:35:00", "TUNISAIR", 8);
    FlightMatching flight14 = new FlightMatching("TJ118", "Marseille - Marseille Provence (MRS)", "Tunis Carthage (TUN)", "18-11-2015 07:30:00", "NOUVEL AIR TUNISIE", 9);
    FlightMatching flight15 = new FlightMatching("AH4001", "Alger - Houari Boumediene Airport (ALG)", "Tunis Carthage (TUN)", "19-11-2015 08:15:00", "AFRIQIYAH AIRWAYS", 10);
    FlightMatching flight16 = new FlightMatching("TU796", "Berlin - Berlin Brandenburg Airport (BER)", "Djerba (DJE)", "17-11-2015 05:35:00", "TUNISAIR", 8);

    FlightMatching flight17 = new FlightMatching("TU416", "Dakar - Léopold Sédar Senghor International Airport (DKR)", "Tabarka (TBJ)", "02-12-2015 21:20:00", "TUNISAIR", 8);
    FlightMatching flight18 = new FlightMatching("BT430", "Londres - Aéroport de Londres Heathrow (LHR)", "Enfidha (NBE)", "03-12-2015 19:40:00", "NOUVEL AIR TUNISIE", 9);
    FlightMatching flight19 = new FlightMatching("TU606", "Madrid - Adolfo Suárez Madrid–Barajas Airport (MAD)", "Tunis Carthage (TUN)", "04-12-2015 16:00:00", "AFRIQIYAH AIRWAYS", 10);
    FlightMatching flight20 = new FlightMatching("UG004", "Palerme - Falcone–Borsellino Airport (PMO)", "Djerba (DJE)", "05-12-2015 14:45:00", "TUNISAIR", 8);

    FlightMatching flight21 = new FlightMatching("TU021", "Belgrade - Belgrade Nikola Tesla (BEG)", "Tunis Carthage (TUN)", "06-12-2015 05:35:00", "TUNISAIR", 8);
    FlightMatching flight22 = new FlightMatching("TR159", "Sarajevo - Sarajevo International Airport (SJJ)", "Sfax El Maou (SFA)", "07-12-2015 05:35:00", "TAROM", 8);
    FlightMatching flight23 = new FlightMatching("TR601", "Bucarest  - Aéroport international Henri Coanda (OTP)", "Tunis Carthage (TUN)", "08-12-2015 05:35:00", "RYANAIR", 8);
    FlightMatching flight24 = new FlightMatching("MEA777", "Beyrouth - Aéroport international de Beyrouth - Rafic Hariri", "Monastir (MIR)", "09-12-2015 05:35:00", "MIDDLE EAST AIRLINES", 8);

    FlightMatching flight25 = new FlightMatching("ZI898", "Paris - Paris Orly (ORY)", "Tunis Carthage (TUN)", "17-11-2015 10-12:00", "AIGLE AZUR", 8);
    FlightMatching flight26 = new FlightMatching("AF6423", "Toulouse - Toulouse Blagnac (TLS)", "Tunis Carthage (TUN)", "11-12-2015 05:35:00", "AIR FRANCE", 8);

    /**********************************FLIGHTS********************************************/


    
    	}

}
