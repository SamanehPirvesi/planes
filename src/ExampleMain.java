import planes.Airport;
import planes.Company;
import planes.PlanesWorld;

public class ExampleMain {

	public static void main(String[] args) {
		
		
	PlanesWorld planesWorld = new PlanesWorld();
		
		Company company=new Company("mahan",planesWorld);
		planesWorld.setCompany(company);
		planesWorld.addAirport("a320");
		planesWorld.addAirport("a560");
		planesWorld.addAirport("a742");
		planesWorld.removeAirport("a320");
		 
		
		//System.out.println(c.toString());
		
//		for (Airport i:control.getAirports()) {
//			System.out.println(i.getAirportCode());
//			
//		}

//		control.removeAirport("a320");
//				for (Airport i:control.getAirports()) {
//			System.out.println(i.getAirportCode());
//				}
//
	}

}
