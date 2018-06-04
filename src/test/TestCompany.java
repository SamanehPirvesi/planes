package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

import exception.InvalidFlightCode;
import exception.InvalidPlaneCode;
import planes.Airport;
import planes.Company;
import planes.PlanesWorld;

public class TestCompany {
	private Company c;
	private PlanesWorld p;
	
	@Before
	public void setUp() throws Exception {	
		p=new PlanesWorld();
		c=new Company("mahan",p);
	
	}
	@Test
	public void testAddPlane () {
		assertNotNull(c);
		try {
			c.addPalne("aav", 300,0);
			assertEquals("if palane mode is null ",1, c.getPlanes().size());
			assertEquals(300,c.getPlanes().stream().findFirst().get().getNumberOfSeats());
			c.addPalne("aav", 300,0);
			fail("it shuold not reach here");

			
		} catch (InvalidPlaneCode e) {
				e.printStackTrace();
		}
		
	}
	@Test
	public void testRemoveFlight() {
		try {
			c.addFlight("a230", "aav", "b450", "g650", "friday");
			assertEquals(1, c.getFlights().size());
			c.removeFlight("a230");
			assertEquals(0, c.getFlights().size());
		} catch (InvalidFlightCode e) {
		
			e.printStackTrace();
		}
		
		
		
	}
	

}
