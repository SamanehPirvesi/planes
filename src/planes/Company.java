package planes;

import java.util.Collection;
import java.util.Map;
import java.util.TreeMap;

public class Company {

	private String companyName;
	private Map<String, Plane> planes = new TreeMap<>();
	private Map<String, Flight> flights = new TreeMap<>();
	private PlanesWorld planesWord;
	private Map<String, Integer> departedDelayList = new TreeMap<>();
	private Map<String, Integer> arrivedDelayList = new TreeMap<>();

	public Company(String companyName, PlanesWorld planesWord) {

		this.companyName = companyName;
		this.planesWord = planesWord;
	}

	public PlanesWorld getPlanesWord() {
		return planesWord;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public Collection<Plane> getPlanes() {
		return planes.values();
	}

	public void setPlanes(Map<String, Plane> planes) {
		this.planes = planes;
	}

	public Collection<Flight> getFlights() {
		return flights.values();
	}

	public void setFlights(Map<String, Flight> flights) {
		this.flights = flights;
	}

	public void addPalne(String planeModel, int numberOfSeats) {

		Plane plane = new Plane(planeModel, numberOfSeats);
		planes.put(planeModel, plane);
	}

	public void addFlight(String flightCode, String planeModel, String departureCode, String arrivalCode,
			String dayOfTheWeek) {
		Flight flight = new Flight(flightCode, planeModel, departureCode, arrivalCode, dayOfTheWeek);
        
		flights.put(flightCode, flight);
	}

	public void removeFlight(String flightCode) {
		flights.remove(flightCode);
	}

	public boolean book(String flightCode, int numberOFPlaceToBook) {
		String target = flights.get(flightCode).getPlaneModel();
		try {

			if (target.equals(planes.get(target).getPlaneModelCode())) {
				int i = planes.get(target).getNumberOfSeats();
				if (i > numberOFPlaceToBook) {
					planes.get(target).setNumberOfSeats(i - numberOFPlaceToBook);
					return true;
				} else {
					return false;
				}

			}
		} catch (Exception e) {
			System.out.println("the code is not valid");
		}
		return false;
	}

	public int freeSeats(String flightCode) {
		String target = flights.get(flightCode).getPlaneModel();
		try {

			if (target.equals(planes.get(target).getPlaneModelCode())) {
				return planes.get(target).getNumberOfSeats();
			}
		} catch (Exception e) {
			System.out.println("the code for finding number of free seats is not valid");
		}

		return 0;
	}

	public void departedFlight(String flightCode, int delay) {
		try {
			if (flightCode.equals(flights.get(flightCode).getFlightCode())) {
				if (delay > 0) {
					departedDelayList.put(flightCode, delay);

				}
			}
		} catch (Exception e) {
			System.out.println("the flight code is not correct");
		}

	}

	public void arrivedFlight(String flightCode, int delay) {
		try {
			if (flightCode.equals(flights.get(flightCode).getFlightCode())) {
				if (delay > 0) {
					arrivedDelayList.put(flightCode, delay);
				}

			}
		} catch (Exception e) {
			System.out.println("the flight code is not correct");
		}

	}

	public Map<String, Integer> getDepartedDelayList() {
		 Map<String, Integer> result = new TreeMap<>();
		 for (Map.Entry<String, Integer> entry : getDepartedDelayList().entrySet()) {
			if(entry.getValue()>15) {
				result.put(entry.getKey(), entry.getValue());
			}
		 }
		return result;
	}

	public Map<String, Integer> getArrivedDelayList() {
		return arrivedDelayList;
	}

}
