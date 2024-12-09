package parctice.se.ex2.module34_36;

class OuterDemo2_Test {
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
}

public class OuterDemo2 {
    public static void main(String[] args) {
        OuterDemo2_Test oc = new OuterDemo2_Test();
        OuterDemo2_Test.InnerClass ic = oc.new InnerClass();
        ic.changeOuterNumber();
        oc.printOuterNumber();
    }
}
