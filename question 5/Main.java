package question5;

import java.io.IOException;
import java.util.*;

public class Main {

	public static void main(String[] args) {


		try {
			Salaryapp app = new Salaryapp("data/data.txt");
			app.printAll();
			System.out.println();
			System.out.println(String.format("Max salary: %.2f", app.getMaxSalary()));
			System.out.println(String.format("Employee ID with min salary: %s", app.getMinSalaryID()));
			app.promoteSalary();
			System.out.println("==========After Salary promotion=======");
			app.printAll();
			System.out.println();
			double total = recursiveTotalSalary(app.getPeople(),0);
			System.out.println(String.format("Total Salary: %.2f", total));
		} catch (IOException ioe) {
			System.out.printf("Perhaps missing text file: %s/data/data.txt? \n\n",
					new Main().getClass().getPackage().getName());

		}

	}


	// recursive method is used to count total salary of employees
	public static double recursiveTotalSalary(List<Employee> list, double accum) {
		if(list != null && list.size() > 0) {
			List<Employee> sublist = list.subList(1,list.size());
			return recursiveTotalSalary(sublist, accum + list.get(0).getSalary());

		} else {
			return accum;
		}
	}

}
