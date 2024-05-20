package se.ex2.module18_20;

import java.util.HashSet;
import java.util.Set;

public class TestHashSetEmp {

    public static void main(String[] args) {
        Set<Employee> set = new HashSet<Employee>();
        Employee em1 = new Employee(7001, "king1");
        Employee em2 = new Employee(7002, "king2");
        Employee em3 = new Employee(7003, "king3");
        Employee em4 = new Employee(7004, "king4");
        Employee em5 = new Employee(7005, "king5");

        set.add(em5);
        set.add(em2);
        set.add(em3);
        set.add(em4);
        set.add(em1);

        for (Employee aEmp2 : set) {
            System.out.println(aEmp2.getEmpno() + "-" + aEmp2.getEname());
        }
    }
}
