package planes;

public class Plane {

	private String planeModelCode;
	private int numberOfSeats;

	public Plane(String planeModelCode, int numberOfSeats) {

		this.planeModelCode = planeModelCode;
		this.numberOfSeats = numberOfSeats;
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
