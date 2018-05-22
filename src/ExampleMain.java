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
		
		Company company=new Company("mahan",planesWorld);
		planesWorld.setCompany(company);
		try {
		planesWorld.addAirport("a320");
		planesWorld.addAirport("a320");
		planesWorld.addAirport("a560");
		planesWorld.addAirport("a742");
		planesWorld.addAirport("a457");
		}catch (InvalidCode ex) {
			System.out.println(ex.getMessage());
		}
		//planesWorld.removeAirport("a320");
		try {
		company.addPalne("Boeing737", 370 , 0);
		company.addPalne("Boeing737", 370 , 0);
		company.addPalne("Boeing777", 460,0);
		}catch (InvalidPlaneCode ex) {
			System.out.println(ex.getMessage());
		}
		try {
		company.addFlight("aav","Boeing737", "a320", "a742", "monday");
		company.addFlight("aav","Boeing737", "a320", "a742", "monday");
		company.addFlight("afv","Boeing777", "a560", "a457", "friday");
		}catch(InvalidFlightCode ex) {
			System.out.println(ex.getMessage());
		}
		try {
		company.book("aav", 270);
		company.book("abv", 270);
		}catch(InvalidFlightCode ex) {
			System.out.println(ex.getMessage());
		}
		try {
		company.departedFlight("aav", 30);
		company.departedFlight("axv", 30);
		}catch(InvalidFlightCode ex) {
			System.out.println(ex.getMessage());
		}
		try {
		company.arrivedFlight("aav",40);
		company.arrivedFlight("hbv",40);
		}catch(InvalidFlightCode ex) {
			System.out.println(ex.getMessage());
		}
		try {
		company.removeFlight("aas");
		}catch(InvalidFlightCode ex) {
			System.out.println(ex.getMessage());
		}
		for (Airport airport:planesWorld.getAirports()) {
		 System.out.println(company.getCompanyName()+"  "+airport.getAirportCode());
		}
		for (Plane plan:company.getPlanes()) {
			System.out.println(plan.getPlaneModelCode()+" "+plan.getNumberOfSeats()+" "+plan.getCounter());
			
		}
		for (Flight flight:company.getFlights()) {
			System.out.println(flight.getFlightCode()+" "+flight.getPlaneModel()+" "+flight.getDepartureCode()+" "+flight.getArrivalCode()+flight.getDayOfTheWeek());
			
		}
	
		for (Airport airport:planesWorld.getAirports()) {
		for (Flight flight:airport.getDepartures()){
		
			System.out.println(flight.getFlightCode()+" "+flight.getPlaneModel()+" "+flight.getDepartureCode()+" "+flight.getArrivalCode()+flight.getDayOfTheWeek());
			
		}}
		try {
		System.out.println(company.freeSeats("aav"));
		System.out.println(company.freeSeats("anv"));
		}catch(InvalidFlightCode ex) {
			System.out.println(ex.getMessage());
		}
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
		
		 for (Map.Entry<String, Integer> criticalFlights:company.CriticalFlights().entrySet()) {
			 System.out.println(criticalFlights.getKey() +" "+ criticalFlights.getValue());
		 }
	}

}
