package se.ex2.module18_20;

import java.util.Objects;

public class Employee implements Comparable<Employee> {
    private int empno;
    private String ename;

    public void setEmpno(int empno) {
        this.empno = empno;
    }

    public int getEmpno() {
        return empno;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public String getEname() {
        return ename;
    }

    public Employee(int empno, String ename) {
        this.empno = empno;
        this.ename = ename;
    }

    public Employee(int empno) {
        this(empno, "-");
    }

    public Employee(String ename) {
        this(0, ename);
    }

    public Employee() {
        this(0, "-"); // 或 empno = 0; ename = "-"
    }

    public void display() {
        System.out.println("empno=" + empno);
        System.out.println("ename=" + ename);
    }

    public int compareTo(Employee aEmployee) {
        // 物件本身與 aEmployee 相比較，如果 retrun 正值，就表示比 aEmployee 大
        if (this.empno > aEmployee.empno) {
            return 1;
        } else if (this.empno == aEmployee.empno) {
            return 0;
        } else {
            return -1; // 正負值用來代表兩個元素的左右位置關係
        }
    }
//	public boolean equals(Object obj) {
//		if (this == obj)
//			return true;
//		if (this.empno == empno && this.ename.equals(ename)) {
//			return true;
//		}
//		return false;
//	}
//
//	public int hashCode() {
//		final int prime=31;
//		int result=1;
//	}

    @Override
    public int hashCode() {
        return Objects.hash(empno, ename);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Employee other = (Employee) obj;
        return empno == other.empno && Objects.equals(ename, other.ename);
    }

}
