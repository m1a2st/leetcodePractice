package practice.se.ex1.module20_23;

public class Employee {
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
    }

    public void display() {
        System.out.println("empno = " + empno);
        System.out.println("ename = " + ename);
    }
}
