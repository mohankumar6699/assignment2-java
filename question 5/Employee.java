package question5;

public class Employee {
	//ID and salary variables created
	private String ID;
	private double salary;
	
	 //getter and setter method for ID
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	
	//getter and setter method for salary
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}

	public Employee(String ID, double salary) {
		this.setID(ID);
		this.setSalary(salary);
	}
	
    //below code is of method for displaying ID and salary text from data.text file
	public void displayEmployee() {
		System.out.println(ID+"     "+salary);
	}
}


