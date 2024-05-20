package se.ex2.module34_36;

class OuterDemo1_Test {
    private int outerNumber = 0;

    public void printOuterNumber() {
        System.out.println("3-再由OuterClass自行列印出外層類別的數值");
        System.out.println("outerNumber=" + outerNumber);
    }

    public class InnerClass {
        public void changeOuterNumber() {
            System.out.println("2-由InnerClass驅動變更外層OuterClass的數值");
            outerNumber++;
        }
    }

    public void event() {
        System.out.println("1-OuterClass發生事件");
        InnerClass ic = new InnerClass();
        ic.changeOuterNumber();
    }
}

public class OuterDemo1 {
    public static void main(String[] args) {
        OuterDemo1_Test oc = new OuterDemo1_Test();
        oc.event();
        oc.printOuterNumber();
    }
}
