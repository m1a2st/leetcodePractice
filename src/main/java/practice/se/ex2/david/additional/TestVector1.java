package practice.se.ex2.david.additional;

import java.util.Vector;

//Vector 為一可置入"任意物件"的"動態陣列"(可隨內含物多寡增減其長度)

public class TestVector1 {
    public static void main(String[] args) {
        Vector v = new Vector();
        v.addElement(Integer.valueOf(12));
        v.addElement(Long.valueOf(34L));
        v.addElement("Hello");

        for (int i = 0; i < v.size(); i++) {
            Object obj = v.elementAt(i);
            System.out.println(obj);
        }
    }
}
