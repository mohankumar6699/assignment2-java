package question3;

public class Shape {

	private String colour; // created a private field "colour"

	//this is for creating getter and setter function for color
	public String getColour() {
		return colour;
	}
	public void setColour(String colour) {
		this.colour = colour;
	}

	// this is for creating parameterized constructor
	public Shape(String colour) {
		this.colour = colour;
	}

	// this is for creating a method which returns the below quoted message
	public String getShapeName() {
		return "I'm a Shape";
	}
}