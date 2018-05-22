package planes;

public class Plane {

	private String planeModelCode;
	private int numberOfSeats;
	private int counter;

	public Plane(String planeModelCode, int numberOfSeats , int counter) {

		this.planeModelCode = planeModelCode;
		this.numberOfSeats = numberOfSeats;
		this.counter=counter;
	}

	public int getCounter() {
		return counter;
	}

	public void setCounter(int counter) {
		this.counter = counter;
	}

	public String getPlaneModelCode() {
		return planeModelCode;
	}

	public void setPlaneModelCode(String planeModelCode) {
		this.planeModelCode = planeModelCode;
	}

	public int getNumberOfSeats() {
		return numberOfSeats;
	}

	public void setNumberOfSeats(int numberOfSeats) {
		this.numberOfSeats = numberOfSeats;
	}

}
