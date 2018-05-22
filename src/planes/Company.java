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

	public void addPalne(String planeModel, int numberOfSeats, int counter) {

		Plane plane = new Plane(planeModel, numberOfSeats, counter);
		planes.put(planeModel, plane);
	}

	public void addFlight(String flightCode, String planeModel, String departureCode, String arrivalCode,
			String dayOfTheWeek) {
		Flight flight = new Flight(flightCode, planeModel, departureCode, arrivalCode, dayOfTheWeek);
		flight.setCompany(this);

		flights.put(flightCode, flight);
	}

	public void removeFlight(String flightCode) {
		flights.remove(flightCode);
	}

	public boolean book(String flightCode, int numberOFPlaceToBook) {
		String target = flights.get(flightCode).getPlaneModel();
		

			if (target.equals(planes.get(target).getPlaneModelCode())) {
				int i = (planes.get(target).getNumberOfSeats()-planes.get(target).getCounter());
				if (i > numberOFPlaceToBook) {
					planes.get(target).setCounter(planes.get(target).getCounter()+ numberOFPlaceToBook);
					return true;
				} else {
					return false;
				}

			}
		return false;
	}

	public int freeSeats(String flightCode) {
		String target = flights.get(flightCode).getPlaneModel();
		

			if (target.equals(planes.get(target).getPlaneModelCode())) {
				int numberOfSeat=planes.get(target).getNumberOfSeats()-planes.get(target).getCounter();
				return numberOfSeat;
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
		for (Map.Entry<String, Integer> entry : departedDelayList.entrySet()) {
			if (entry.getValue() > 15) {
				result.put(entry.getKey(), entry.getValue());
			}
		}
		return result;
	}

	public Map<String, Integer> getArrivedDelayList() {
		Map<String, Integer> result = new TreeMap<>();
		for (Map.Entry<String, Integer> entry : arrivedDelayList.entrySet()) {
			if (entry.getValue() > 15) {
				result.put(entry.getKey(), entry.getValue());
			}
		}
		return result;
	}

	public Map<String, Integer> CriticalFlights() {
		Map<String, Integer> ciriticalFlightsMap = new TreeMap<>();
		for (Flight flight : flights.values()) {
			for (Plane plane : planes.values()) {
				if ((flight.getPlaneModel().equals(plane.getPlaneModelCode()))
						&& (plane.getCounter() < (plane.getNumberOfSeats() * 0.3))) {
					ciriticalFlightsMap.put(flight.getFlightCode(),( plane.getNumberOfSeats()-plane.getCounter()));
				}
			}

		}
		return ciriticalFlightsMap;
	}

}
