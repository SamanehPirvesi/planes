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
		company.addPalne("boeing777", 460);
		company.addFlight("aav","Boeing737", "a320", "a742", "monday");
		company.addFlight("afv","Boeing777", "a560", "a457", "friday");
		company.book("aav", 50);
		company.arrivedFlight("aav", 30);
		company.arrivedFlight("afv",50);
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
		for (Flight f:airport.getDepartures()){
		
			System.out.println(f.getFlightCode()+" "+f.getPlaneModel()+" "+f.getDepartureCode()+" "+f.getArrivalCode()+f.getDayOfTheWeek());
			
		}}
		System.out.println(company.freeSeats("aav"));
//		for(Integer i:company.getDepartedDelayList().values()) {
//			System.out.println(i.);
//		}
	
	}

}
