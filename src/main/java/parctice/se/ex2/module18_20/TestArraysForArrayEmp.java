package main.java.parctice.se.ex2.module18_20;

import java.util.Arrays;

public class TestArraysForArrayEmp {

    public static void main(String[] args) {

        Employee[] e = new Employee[5];
        Employee e1 = new Employee(7001, "king1");
        Employee e2 = new Employee(7002, "king2");
        Employee e3 = new Employee(7003, "king3");
        Employee e4 = new Employee(7004, "king4");
        Employee e5 = new Employee(7005, "king5");

        e[0] = e5;
        e[1] = e2;
        e[2] = e3;
        e[3] = e4;
        e[4] = e1;

        Arrays.sort(e);

        for (int i = 0; i < e.length; i++) {
            Employee aEmp = e[i];
            System.out.println(aEmp.getEmpno() + "-" + aEmp.getEname());
        }
    }


}
