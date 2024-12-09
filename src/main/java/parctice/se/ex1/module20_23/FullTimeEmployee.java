package parctice.se.ex1.module20_23;

public class FullTimeEmployee extends Employee {
    private final double monthlySalary; // 月薪

    public void display() {
        super.display();
        System.out.println("月薪 = " + monthlySalary);
    }

    public FullTimeEmployee(int empno, String ename, double monthlySalary) {
        super(empno, ename);
        this.monthlySalary = monthlySalary;

    }

    public double getFullTimeEmployee() {
        return monthlySalary;
    }
}
