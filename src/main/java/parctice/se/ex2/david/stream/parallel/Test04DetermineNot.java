package main.java.parctice.se.ex2.david.stream.parallel;


import main.java.parctice.se.ex2.david.stream.Employee;
import main.java.parctice.se.ex2.david.stream.Role;

import java.util.List;
import java.util.Optional;

public class Test04DetermineNot {

    public static void main(String[] args) {

        List<Employee> empList = Employee.createShortList();

        Optional<Employee> e1 = empList.stream()
                .filter(e -> e.getRole().equals(Role.EXECUTIVE))
                .sequential()
                .findAny();

        Optional<Employee> e2 = empList.stream()
                .filter(e -> e.getRole().equals(Role.EXECUTIVE))
                .parallel()
                .findAny();

        System.out.println("The same: " + e1.get().getEmail().equals(e2.get().getEmail()));

    }
}
