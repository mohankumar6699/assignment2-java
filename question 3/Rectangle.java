package question3;

public class Rectangle extends Shape {
	// created two private variables
	private double height;
	private double width;

	//getter and setter for height
	public double getHeight() {
		return height;
	}
	public void setHeight(double height) {
		this.height = height;
	}
	
	//getter and setter for width
	public double getWidth() {
		return width;
	}
	public void setWidth(double width) {
		this.width = width;
	}

	// below code is to create constructor for rectangle with three parameters
	public Rectangle(String colour, double height, double width) {
		super(colour);
		this.height = height;
		this.width = width;
	}

	// override method
	@Override public String getShapeName() {
		return "I'm a Rectangle";
	}

	// public method to calculate and return the perimeter value
	public double getPerimeter() {
		double perimeter = 2*(height + width);
		return perimeter;
	}
}
