package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import exception.InvalidCode;
import exception.InvalidFlightCode;
import junit.framework.Assert;
import planes.Airport;
import planes.Company;
import planes.PlanesWorld;

public class TestAirPort {
	private Airport a ;
	//
//	@BeforeClass
//	public static void setUpBeforeClass() throws Exception {
//		System.out.println("before class");
//	}

	@Before
	public void setUp() throws Exception {		
		 a = new Airport("a457");
		a.setAirportCode("a742");
		
	}

	@Test
	public void getArrived() {
		PlanesWorld planesWorld = new PlanesWorld();
		Company company = new Company("mahan", planesWorld);
	    a.setCompany(company);
		try {
			company.addFlight("aav", "Boeing737", "a320", "a742", "monday");
			 company.addFlight("aab", "Boeing737", "a320", "a742", "monday");
			 company.addFlight("afv", "Boeing777", "a560", "a742", "friday");

			//

//			List<String> test = Arrays.asList();
//			Airport a = new Airport("a457");
//			a.setAirportCode("a742");
			assertEquals("aab",a.getArrived().get(0).getFlightCode());
			assertEquals(3, a.getArrived().size());
			assertEquals("afv",a.getArrived().get(2).getFlightCode());
			

		} catch (InvalidFlightCode ex) {

		}
	}
}
