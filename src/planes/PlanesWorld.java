package planes;

import java.util.Collection;
import java.util.Map;
import java.util.TreeMap;

import exception.InvalidCode;

public class PlanesWorld {
	private Company company;
	private Map<String, Airport> airports = new TreeMap<>();
	public Company getCompany() {
		return company;
	}
	public void setCompany(Company company) {
		this.company = company;
	}
	public Collection<Airport> getAirports() {
		return airports.values();
	}
	public Airport getAirportByCode(String airportCode) {
		return airports.get(airportCode);
	}
	public void addAirport( String airportCode) throws InvalidCode {
if (airports.get(airportCode)!=null) {
	throw new InvalidCode("the airport has been inserted already");
}
		Airport newAirport = new Airport(airportCode);
		newAirport.setCompany(this.company);
		airports.put(airportCode, newAirport);
	}

	public void removeAirport(String airportCode) {

		airports.remove(airportCode);
	}

}
