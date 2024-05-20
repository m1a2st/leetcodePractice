package se.ex2.module34_36;

class Outer3 {
    static int x = 1;
    int y = 2;

    //因為外部區域變數會複製一份值給方法內部類別，即便在方法內部類別改變這副本的值，也不會影響到原區域變數的值
    //Java就乾脆規定，若方法內的類別要存取外部區域變數，就不允許值被改變，而加上final就可以達到此目的
    public void outerMethod(final int a) {
        int b = 5;
        class Inner {
            public final int z = 3;

            public void show() {
                System.out.println("x = " + x);
                System.out.println("y = " + y);
                System.out.println("z = " + z);
                System.out.println("a = " + a);
                //b是外部的區域變數，必須加上final修飾子，否則會編譯失敗
//				System.out.println("b = " + b);
            }
        }
        //Inner類別物件的建立需在第10行類別定義之後才能使用
        Inner inner = new Inner();
        inner.show();
    }
}

public class LocalInner {
    public static void main(String[] args) {
        Outer3 outer = new Outer3();
        outer.outerMethod(4);
    }
}
