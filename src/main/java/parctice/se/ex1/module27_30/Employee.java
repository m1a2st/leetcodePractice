package parctice.se.ex1.module27_30;

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
        this(0, "-");
    }

    public void display() {
        System.out.println("empno=" + empno);
        System.out.println("ename=" + ename);
    }

    public boolean equals(Object obj) {
        // 仍要使用==來判斷，因為(也許)要比較的"物件參考變數"，其實指的是同一個實體(指向同一個記憶體空間)
        if (this == obj)
            return true;
        // 用(Object類別的)getClass()來確定是否隸屬於同一個class的物件
        if (obj != null && getClass() == obj.getClass()) {
            if (obj instanceof Employee e) {
                // 為了可以存取到empno/ename, 需要把obj型別轉回成Employee
                // 選擇該類別的必要成員變數(實體變數)來加以判斷是否有相等(相同)
                return empno == e.empno && ename.equals(e.ename);
            }
        }
        return false;
    }

//	public int hashCode() {
//		// 借用一下 String 類別現有的hashCode運算法則
//		return this.ename.hashCode(); 
//		// 或借用一下 Integer類別現有的hashCode運算法則
//		// return new Integer(this.empno).hashCode(); 
//	}
}
