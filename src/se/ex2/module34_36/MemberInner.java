package se.ex2.module34_36;

class Outer2 {
    static int x = 1;
    int y = 2;

    public class Inner {
        public int z = 3;

        public void show() {
            System.out.println("Outer2.x = " + Outer2.x);
            System.out.println("Outer2.this.y = " + Outer2.this.y);
            System.out.println("this.z = " + this.z);
        }
    }
}

public class MemberInner {
    public static void main(String[] args) {
        //因為實體內部類別依附在物件實體上，所以必須先產生外部類別的物件實體才能再產生內部類別的物件實體
        //new Outer2()即代表外部類別的物件實體
        Outer2.Inner inner = new Outer2().new Inner();
        inner.show();
    }
}
