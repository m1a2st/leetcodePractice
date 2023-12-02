package se.ex2.david.stream.parallel;

import se.ex2.david.stream.Employee;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


public class Test02AvoidStateful {

	public static void main(String[] args) {
		List<Employee> empList = Employee.createShortList();
		List<Employee> newList01 = new ArrayList<>();

		empList.parallelStream() // Not Parallel. Bad.
				.filter(e -> e.getDept().equals("Eng"))
				.forEach(e -> newList01.add(e));

		List<Employee> newList02 = empList.parallelStream() // Good Parallel
				.filter(e -> e.getDept().equals("Eng"))
				.collect(Collectors.toList());

	}
}
