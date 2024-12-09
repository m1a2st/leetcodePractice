package main.java.parctice.se.ex2.module18_20;

import java.util.Set;
import java.util.TreeSet;

public class TestTreeSetEmp {
    public static void main(String[] args) {
        Set<Employee> set = new TreeSet<Employee>();
        Employee e1 = new Employee(7001, "king1");
        Employee e2 = new Employee(7002, "king2");
        Employee e3 = new Employee(7003, "king3");
        Employee e4 = new Employee(7004, "king4");
        Employee e5 = new Employee(7005, "king5");

        set.add(e5);
        set.add(e2);
        set.add(e3);
        set.add(e4);
        set.add(e1);

        for (Employee aEmp : set) {
            System.out.println(aEmp.getEmpno() + "-" + aEmp.getEname());
        }

    }
}
