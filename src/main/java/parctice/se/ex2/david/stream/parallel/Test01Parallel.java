package parctice.se.ex2.david.stream.parallel;


import parctice.se.ex2.david.stream.Employee;
import parctice.se.ex2.david.stream.Role;

import java.util.List;

public class Test01Parallel {

    public static void main(String[] args) {

        List<Employee> empList = Employee.createShortList();

        double result = empList.parallelStream()
                .filter(e -> e.getState().equals("CO"))
                .filter(e -> e.getRole().equals(Role.EXECUTIVE))
                .peek(e -> e.printSummary())
                .mapToDouble(e -> e.getSalary())
                .sum();

        System.out.printf("Total CO Executive Pay: $%,9.2f %n", result);

        System.out.println("\n");

        // Call parallel from pipeline
        result = empList.stream()
                .filter(e -> e.getState().equals("CO"))
                .filter(e -> e.getRole().equals(Role.EXECUTIVE))
                .peek(e -> e.printSummary())
                .mapToDouble(e -> e.getSalary())
                .parallel()
                .sum();

        System.out.printf("Total CO Executive Pay: $%,9.2f %n", result);

        System.out.println("\n");

        // Call sequential from pipeline
        result = empList.stream()
                .filter(e -> e.getState().equals("CO"))
                .filter(e -> e.getRole().equals(Role.EXECUTIVE))
                .peek(e -> e.printSummary())
                .mapToDouble(e -> e.getSalary())
                .sequential()
                .sum();

        System.out.printf("Total CO Executive Pay: $%,9.2f %n", result);
    }
}
