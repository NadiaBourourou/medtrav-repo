package entities;

import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;
import java.util.Date;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: FlightMatching
 *
 */
@Entity
public class FlightMatching implements Serializable {

	private Integer idFlightMatching;
	private String numFlight;
	private String departure;
	private String arrival;
	private String dateFlightMatching;
	private String airline;
	private Integer numberOfSits;
	private static final long serialVersionUID = 1L;

	public FlightMatching() {
		super();
	}

	
	public FlightMatching(String numFlight, String departure, String arrival,
			String dateFlightMatching, String airline, Integer numberOfSits) {
		super();
		this.numFlight = numFlight;
		this.departure = departure;
		this.arrival = arrival;
		this.dateFlightMatching = dateFlightMatching;
		this.airline = airline;
		this.numberOfSits = numberOfSits;
	}



	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getIdFlightMatching() {
		return this.idFlightMatching;
	}

	public void setIdFlightMatching(Integer idFlightMatching) {
		this.idFlightMatching = idFlightMatching;
	}

	public String getNumFlight() {
		return this.numFlight;
	}

	public void setNumFlight(String numFlight) {
		this.numFlight = numFlight;
	}

	public String getDeparture() {
		return this.departure;
	}

	public void setDeparture(String departure) {
		this.departure = departure;
	}

	public String getArrival() {
		return this.arrival;
	}

	public void setArrival(String arrival) {
		this.arrival = arrival;
	}

	public String getDateFlightMatching() {
		return this.dateFlightMatching;
	}

	public void setDateFlightMatching(String dateFlightMatching) {
		this.dateFlightMatching = dateFlightMatching;
	}

	public String getAirline() {
		return this.airline;
	}

	public void setAirline(String airline) {
		this.airline = airline;
	}

	public Integer getNumberOfSits() {
		return this.numberOfSits;
	}

	public void setNumberOfSits(Integer numberOfSits) {
		this.numberOfSits = numberOfSits;
	}

}
