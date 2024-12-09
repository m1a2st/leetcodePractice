package parctice.se.ex2.module18_20;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TestCollectionsForListEmp {

    public static void main(String[] args) {
        List<Employee> list = new ArrayList<Employee>();
        Employee e1 = new Employee(7001, "king1");
        Employee e2 = new Employee(7002, "king2");
        Employee e3 = new Employee(7003, "king3");
        Employee e4 = new Employee(7004, "king4");
        Employee e5 = new Employee(7005, "king5");

        list.add(e5);
        list.add(e2);
        list.add(e3);
        list.add(e4);
        list.add(e1);

        Collections.sort(list);
//		Collections.reverse(list);

        for (Employee aEmp : list) {
            System.out.println(aEmp.getEmpno() + "-" + aEmp.getEname());
        }
    }
}
