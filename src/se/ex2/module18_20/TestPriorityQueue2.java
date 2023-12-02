package se.ex2.module18_20;

import java.util.*;
//class MyComparator implements Comparator<String> {
//	public int compare(String s1,String s2) {
//		return s1.compareTo(s2)*-1;
//	}
//	
//}

public class TestPriorityQueue2 {
	public static void main(String[] args) {
		//匿名類別語法(對介面實作的簡化)
		Comparator<String> c = new Comparator<String>() {
			public int compare(String a, String b) {
				return a.compareTo(b) * -1;
			}
		};
		PriorityQueue<String> pq = new PriorityQueue<String>(3, c);
		pq.offer("c");
		pq.offer("a");
		pq.offer("b");
		String s;
		while ((s = pq.poll()) != null) {
			System.out.print(s + ", ");
		}
	}
}
