import java.util.Map;

import planes.Airport;
import planes.Company;
import planes.Flight;
import planes.Plane;
import planes.PlanesWorld;

public class ExampleMain {

	public static void main(String[] args) {
		
		
	PlanesWorld planesWorld = new PlanesWorld();
		
		Company company=new Company("mahan",planesWorld);
		planesWorld.setCompany(company);
		planesWorld.addAirport("a320");
		planesWorld.addAirport("a560");
		planesWorld.addAirport("a742");
		planesWorld.addAirport("a457");
		//planesWorld.removeAirport("a320");
		company.addPalne("Boeing737", 370);
		company.addPalne("Boeing777", 460);
		company.addFlight("aav","Boeing737", "a320", "a742", "monday");
		company.addFlight("afv","Boeing777", "a560", "a457", "friday");
		company.book("aav", 50);
		company.departedFlight("aav", 30);
		company.arrivedFlight("afv",40);
		//company.removeFlight("aav");
		for (Airport airport:planesWorld.getAirports()) {
		 System.out.println(company.getCompanyName()+"  "+airport.getAirportCode());
		}
		for (Plane plan:company.getPlanes()) {
			System.out.println(plan.getPlaneModelCode()+plan.getNumberOfSeats());
			
		}
		for (Flight flight:company.getFlights()) {
			System.out.println(flight.getFlightCode()+" "+flight.getPlaneModel()+" "+flight.getDepartureCode()+" "+flight.getArrivalCode()+flight.getDayOfTheWeek());
			
		}
	
		for (Airport airport:planesWorld.getAirports()) {
		for (Flight flight:airport.getDepartures()){
		
			System.out.println(flight.getFlightCode()+" "+flight.getPlaneModel()+" "+flight.getDepartureCode()+" "+flight.getArrivalCode()+flight.getDayOfTheWeek());
			
		}}
		System.out.println(company.freeSeats("aav"));
		for (Map.Entry<String, Integer> entry : company.getDepartedDelayList().entrySet())
		{
			
		    System.out.println(entry.getKey() + "/" + entry.getValue());
		}
	
		for (Map.Entry<String, Integer> entry : company.getArrivedDelayList().entrySet())
		{
			
		    System.out.println(entry.getKey() + "/" + entry.getValue());
		}
		 for (Flight flight:company.getFlights()) {
			
			 
			 System.out.println(flight.toString());
		 }
		
	}

}
