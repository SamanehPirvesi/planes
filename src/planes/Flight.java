package planes;

public class Flight {
	private String flightCode;
	private String planeModel;
	private String departureCode;
	private String arrivalCode;
	private String dayOfTheWeek;
	private Company company;

	public Flight(String flightCode, String planeModel, String departureCode, String arrivalCode, String dayOfTheWeek) {

		this.flightCode = flightCode;
		this.planeModel = planeModel;
		this.departureCode = departureCode;
		this.arrivalCode = arrivalCode;
		this.dayOfTheWeek = dayOfTheWeek;
	}
	

	public Company getCompany() {
		return company;
	}


	public void setCompany(Company company) {
		this.company = company;
	}


	public String getFlightCode() {
		return flightCode;
	}

	public void setFlightCode(String flightCode) {
		this.flightCode = flightCode;
	}

	public String getPlaneModel() {
		return planeModel;
	}

	public void setPlaneModel(String planeModel) {
		this.planeModel = planeModel;
	}

	public String getDepartureCode() {
		return departureCode;
	}

	public void setDepartureCode(String departureCode) {
		this.departureCode = departureCode;
	}

	public String getArrivalCode() {
		return arrivalCode;
	}

	public void setArrivalCode(String arrivalCode) {
		this.arrivalCode = arrivalCode;
	}

	public String getDayOfTheWeek() {
		return dayOfTheWeek;
	}

	public void setDayOfTheWeek(String dayOfTheWeek) {
		this.dayOfTheWeek = dayOfTheWeek;
	}

	public String toString() {
		String toString=null;
		for (Plane plane:company.getPlanes()) {
		if (planeModel.equals(plane.getPlaneModelCode())) {
	    toString=company.getCompanyName()+";"+flightCode+ ";" + planeModel + ";" + departureCode + ";" + arrivalCode + ";" + dayOfTheWeek+";"+plane.getNumberOfSeats();
		}
					}
//		company.getPlanes().stream().forEach(c->{
//			if (planeModel.equals(c.getPlaneModelCode())) {
//			    toString=company.getCompanyName()+";"+flightCode+ ";" + planeModel + ";" + departureCode + ";" + arrivalCode + ";" + dayOfTheWeek+";"+c.getNumberOfSeats();
//				}});
//		
		return toString;
		
}
	}
