package question3;

import static java.lang.System.out;
import java.util.*;



public class Main {

	public static void main(String[] args) {
		List<Shape> shapes = new LinkedList<>();
		shapes.add(new Shape("white"));
		shapes.add(new Rectangle("red", 10, 6));
		shapes.add(new Rectangle("black", 20, 9));
		shapes.add(new Shape("orange"));
		
		//displays first output
		showShapeNames(shapes); 
		
		// below code for rectangle array1
		Rectangle[] rectangleArray1 = {
				new Rectangle("white", 4, 3),
				new Rectangle("red", 9, 5),
				new Rectangle("purple", 3, 6),
				new Rectangle("orange", 15, 10),
				new Rectangle("black", 4, 14),
		};
		// below code for rectangle array2
		Rectangle[] rectangleArray2 = {
				new Rectangle("pink", 3, 4),
				new Rectangle("red", 10, 2),
				new Rectangle("white", 8, 5),
				new Rectangle("blue", 14, 4),
				new Rectangle("bindle", 10, 15),
		};
		
		//displays second output
		countOverlapRectangles(rectangleArray1, rectangleArray2); 
	}
	
	// below code for to displaying the shapes
	public static void showShapeNames(List<Shape> shapes){
		out.printf("Sample run output part 1:\n");
		
		//iterating the list "shapes" by invoking getShapeName() for each instance
		for(int i = 0; i<shapes.size(); i++) { 
			out.printf("%s\n", shapes.get(i).getShapeName());
		}
	}
	
	// method for count overlapping color and parameter
	public static void countOverlapRectangles(Rectangle[] group1, Rectangle[] group2){
		int countcolour = 0;
		int countperimeter = 0 ;
		for(int i = 0; i<group1.length; i++) {
			for(int j = 0; j<group2.length; j++) {
				if(group1[i].getPerimeter() == group2[j].getPerimeter()) {
					countperimeter++;
				}
			}
		}
		for(int i = 0; i<group1.length; i++) {
			for(int j = 0; j<group2.length; j++) {
				if(group1[i].getColour().equals(group2[j].getColour())) {
					countcolour++;
				}
			}
		}
		out.printf("\nSample run output part 2:\n");
		out.printf("There are %d Rectangle objects with overlapping colour between two arrays\n", countcolour);
		out.printf("There are %d Rectangle objects with overlapping perimeter between two arrays\n", countperimeter);
	}
}

