package test;

import static org.junit.Assert.assertEquals;

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

//		
		@BeforeClass  
	    public static void setUpBeforeClass() throws Exception {  
	        System.out.println("before class");  
	    }  
	    @Before  
	    public void setUp() throws Exception {  
	        System.out.println("before");  
	    }  
	  
	    @Test  
	    public void getArrived(){  
	        System.out.println("test case find max");
	        PlanesWorld planesWorld = new PlanesWorld();
	        Company company = new Company("mahan", planesWorld);
	        try {
	        company.addFlight("aav", "Boeing737", "a320", "a742", "monday");
			company.addFlight("aav", "Boeing737", "a320", "a742", "monday");
			company.addFlight("afv", "Boeing777", "a560", "a457", "friday");
			
			 } catch (InvalidFlightCode ex) {
				
			}
	        List<String> test=Arrays.asList("aav", "Boeing737", "a320", "a742", "monday");
	       Airport a=new Airport("a457");
	       assertEquals(test,a.getArrived());
//	       Assert.assertNotNull("Provided List is null;",test);
//	       Assert.assertNotNull("Received List is null;", a.getArrived());
//	       Assert.assertEquals("Size mismatch for lists;", test.size(), a.getArrived().size());
//	       Assert.assertTrue("Missing values in received list; Missing: " + Collection.subtract(test, a.getArrived()) + "; ", a.getArrived().containsAll(test));
//	      
	    }  
}
