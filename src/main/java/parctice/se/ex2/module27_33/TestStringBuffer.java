package main.java.parctice.se.ex2.module27_33;

public class TestStringBuffer {
    public static void main(String[] args) {

        System.out.println("Hello Java " + "StringBuffer!");

//		StringBuffer sb = new StringBuffer("Hello  StringBuffer!");
//		sb.insert(6, "Java");
//		System.out.println(sb);


//		StringBuffer sb = new StringBuffer("Hello Java StringBuffer!");
//		sb.delete(6,10); System.out.println(sb);


//		StringBuffer sb = new StringBuffer("Hello Java StringBuffer!");
//		sb.replace(7,10,"AVA"); System.out.println(sb);


        /*
         * 測試用: -StringBuffer類別是在原字串所在記憶體位置改變字串內容 -未覆寫(Override) Object類別的
         * equals method
         */


//		StringBuffer sb1 = new StringBuffer("AB");
//		System.out.println("sb1= " + sb1);		//AB
//
//		StringBuffer sb2 = sb1.append("CD"); 
//		System.out.println("sb1= " + sb1);		//ABCD 
//		System.out.println("sb2= " + sb2);		//ABCD
//
//		System.out.println(sb1 == sb2); 			//true
//		System.out.println(sb2.equals(sb1));		//true


    }
}
