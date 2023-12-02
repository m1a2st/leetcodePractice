package se.ex2.david.additional;

import java.util.*;

//Vector 為一可置入"任意物件"的"動態陣列"(可隨內含物多寡增減其長度)

public class TestVector1 {
	public static void main(String args[]) {
		Vector v = new Vector();
		v.addElement(new Integer(12));
		v.addElement(new Long(34L));
		v.addElement(new Float(5.6f));
		v.addElement(new Double(7.8));
		v.addElement(new String("Hello"));

		for (int i = 0; i < v.size(); i++) {
			Object obj = v.elementAt(i);
			System.out.println(obj);
		}
	}
}
