package planes;

import java.util.ArrayList;

import java.util.List;
import java.util.stream.Collectors;

public class Airport {
	private String airportCode;
	private Company company;

	public Airport(String airportCode) {

		this.airportCode = airportCode;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public String getAirportCode() {
		return airportCode;
	}

	public void setAirportCode(String airportCode) {
		this.airportCode = airportCode;
	}

	public List<Flight> getArrived() {

		List<Flight> listOfArrived = company.getFlights().stream()
				.filter(c->c.getArrivalCode().equals(airportCode))
				.collect(Collectors.toList());
//		List<Flight> listOfArrived = new ArrayList<>();
//		for (Flight flight : company.getFlights()) {
//			if (flight.getArrivalCode().equals(airportCode)) {
//				listOfArrived.add(flight);
//			}
//			}
		return listOfArrived;
	}
	public List<Flight> getDepartures() {
		List<Flight> listOfDepartures= company.getFlights().stream()
				.filter(f->f.getDepartureCode().equals(airportCode))
				.collect(Collectors.toList());
		
//		List<Flight> listOfDepartures=new ArrayList<>();
//		for (Flight flight : company.getFlights()) {
//			if (flight.getDepartureCode().equals(airportCode)) {
//				listOfDepartures.add(flight);
//
//			}
//		}

		return listOfDepartures;
	}

}
