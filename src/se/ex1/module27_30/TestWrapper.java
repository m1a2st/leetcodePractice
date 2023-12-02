package se.ex1.module27_30;

public class TestWrapper {

	public static void main(String[] args) {
		Integer wInt =Integer.valueOf(1);
		// JDK 1.4以前，一定要像這樣先做轉型的動作，轉型回int才能運算
		int x = wInt.intValue();
		int y = Integer.parseInt("1");
		System.out.println(x + y);

	}

}
