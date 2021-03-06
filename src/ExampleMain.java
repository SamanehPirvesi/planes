import java.util.Map;

import exception.InvalidCode;
import exception.InvalidFlightCode;
import exception.InvalidPlaneCode;
import planes.Airport;
import planes.Company;
import planes.Flight;
import planes.Plane;
import planes.PlanesWorld;

public class ExampleMain {

	public static void main(String[] args) {

		PlanesWorld planesWorld = new PlanesWorld();

		Company company = new Company("mahan", planesWorld);
		planesWorld.setCompany(company);
		try {
			planesWorld.addAirport("a320");
			planesWorld.addAirport("a320");
			planesWorld.addAirport("a560");
			planesWorld.addAirport("a742");
			planesWorld.addAirport("a457");
		} catch (InvalidCode ex) {
			System.out.println(ex.getMessage());
		}
		// planesWorld.removeAirport("a320");
		try {
			company.addPalne("Boeing737", 370, 0);
			company.addPalne("Boeing737", 370, 0);
			company.addPalne("Boeing777", 460, 0);
		} catch (InvalidPlaneCode ex) {
			System.out.println(ex.getMessage());
		}
		try {
			company.addFlight("aav", "Boeing737", "a320", "a742", "monday");
			company.addFlight("aav", "Boeing737", "a320", "a742", "monday");
			company.addFlight("afv", "Boeing777", "a560", "a457", "friday");
		} catch (InvalidFlightCode ex) {
			System.out.println(ex.getMessage());
		}
		try {
			company.book("aav", 70);
			company.book("abv", 270);
		} catch (InvalidFlightCode ex) {
			System.out.println(ex.getMessage());
		}
		try {
			company.departedFlight("aav", 30);
			company.departedFlight("axv", 30);
		} catch (InvalidFlightCode ex) {
			System.out.println(ex.getMessage());
		}
		try {
			company.arrivedFlight("aav", 40);
			company.arrivedFlight("hbv", 40);
		} catch (InvalidFlightCode ex) {
			System.out.println(ex.getMessage());
		}
		try {
			company.removeFlight("aas");
		} catch (InvalidFlightCode ex) {
			System.out.println(ex.getMessage());
		}
		// for (Airport airport:planesWorld.getAirports()) {
		// System.out.println(company.getCompanyName()+" "+airport.getAirportCode());
		// }
		planesWorld.getAirports().stream()
				.forEach(s -> System.out.println(company.getCompanyName() + "  " + s.getAirportCode()));
		// for (Plane plan:company.getPlanes()) {
		// System.out.println(plan.getPlaneModelCode()+" "+plan.getNumberOfSeats()+"
		// "+plan.getCounter());
		// }
		company.getPlanes().stream().forEach(
				c -> System.out.println(c.getPlaneModelCode() + " " + c.getNumberOfSeats() + " " + c.getCounter()));
		// for (Flight flight:company.getFlights()) {
		// System.out.println(flight.getFlightCode()+" "+flight.getPlaneModel()+"
		// "+flight.getDepartureCode()+"
		// "+flight.getArrivalCode()+flight.getDayOfTheWeek());
		// }
		company.getFlights().stream().forEach(cg -> System.out.println(cg.getFlightCode() + " " + cg.getPlaneModel()
				+ " " + cg.getDepartureCode() + " " + cg.getArrivalCode() + cg.getDayOfTheWeek()));
		// for (Airport airport:planesWorld.getAirports()) {
		// for (Flight flight:airport.getDepartures()){
		// System.out.println(flight.getFlightCode()+" "+flight.getPlaneModel()+"
		// "+flight.getDepartureCode()+"
		// "+flight.getArrivalCode()+flight.getDayOfTheWeek());
		// }}
		planesWorld.getAirports().stream().forEach(pg -> {
			pg.getDepartures().forEach(ag -> System.out.println(ag.getFlightCode() + " " + ag.getPlaneModel() + " "
					+ ag.getDepartureCode() + " " + ag.getArrivalCode() + ag.getDayOfTheWeek()));
		});
		try {
			System.out.println(company.freeSeats("aav"));
			System.out.println(company.freeSeats("anv"));
		} catch (InvalidFlightCode ex) {
			System.out.println(ex.getMessage());
		}
//		for (Map.Entry<String, Integer> entry : company.getDepartedDelayList().entrySet()) {
//
//			System.out.println("departed delay list" + entry.getKey() + "/" + entry.getValue());
//		}
		company.getDepartedDelayList().entrySet().stream().
		forEach(ge->System.out.println("departed delay list" + ge.getKey() + "/" +ge.getValue()));
//		for (Map.Entry<String, Integer> entry : company.getArrivedDelayList().entrySet()) {
//			System.out.println("arrived delay list" + entry.getKey() + "/" + entry.getValue());
//		}
		company.getArrivedDelayList().entrySet().stream()
		.forEach(ge->System.out.println("arrived delay list" +ge.getKey() + "/" + ge.getValue()));
//		for (Flight flight : company.getFlights()) {
//		System.out.println(flight.toString());
//		}
		 company.getFlights().stream().forEach(cg->System.out.println(cg.toString()));
//		for (Map.Entry<String, Integer> criticalFlights : company.CriticalFlights().entrySet()) {
//			System.out.println("critical flight" + criticalFlights.getKey() + " " + criticalFlights.getValue());
//		}
		 company.CriticalFlights().entrySet().stream().forEach(c->System.out.println("critical flight" +c.getKey() + " " +c.getValue()));
	}

}
