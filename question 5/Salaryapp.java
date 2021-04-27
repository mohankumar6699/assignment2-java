package question5;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.LinkedList;
import java.util.List;


public class Salaryapp {
	
	private List<Employee> people; //creates list 
	public List<Employee> getPeople() {
		return people;
	}
	public Salaryapp(String filename) throws IOException {
		people = new LinkedList<>();
		readData(filename); 
	}
	public void readData(String fn) throws IOException {
		Path path = new File(fn).toPath();
		List<String> content = Files.readAllLines(path);

		for (String line : content) {
			String[] items = line.split(","); //splits the line into two items
			Employee emp = new Employee(items[0], Double.valueOf(items[1]));
			people.add(emp); //this will add emp value to list
		}
	}
	//below code will print list of all employees with salary
	public void printAll() {
		System.out.println("ID     Salary");
		System.out.println("-------------------");
		for (Employee emp : people) {
			emp.displayEmployee();
		}
	}
	
	//below code will display the highest salary of an employee
	public double getMaxSalary() {
		double sal = people.get(0).getSalary();
		for (Employee list : people ) {
			double sal1 = list.getSalary();
			if (sal <= sal1)
				sal = sal1;
		}
		return sal;
	}
	
    //below code will display employee with minimum salary
	public String getMinSalaryID() {
		double sal = people.get(0).getSalary();
		String id = people.get(0).getID();
		for (Employee list : people) {
			double sal1 = list.getSalary();
			if (sal >= sal1)
				sal = sal1;
			id = list.getID();
		}
		return id;
	}
	
	//this will increase the salary of the employees
	public void promoteSalary() {
		for (Employee list : people) {
			double sal = list.getSalary();
			sal = sal + 2000;  //2000 increase of salary
			if(sal > 100000) {  //if condition to check salary greater than 100000, if so it will be 100000 anyway
				sal = 100000;
				list.setSalary(sal);
			}
			else {
				list.setSalary(sal);
			}
		}
	}

}