package se.ex2.david.additional;

import java.util.Vector;

//Vector 為一可置入"任意物件"的"動態陣列"(可隨內含物多寡增減其長度)
public class TestVector2 {
    public static void main(String[] args) {
        Vector v = new Vector();
        v.add(Integer.valueOf(12));
        v.add(Long.valueOf(34L));
        v.add(new Float(5.6f));
        v.add(new Double(7.8));
        v.add("Hello");

        for (int i = 0; i < v.size(); i++) {
            Object obj = v.get(i);
            System.out.println(obj);
        }
    }
}
