package se.ex1.module12_15;

/*
 * 此範例為一維陣列的基本使用示範
 */
public class TestOneDimArray {

	public static void main(String[] args) {

		int[] intArray = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };

		int sum = 0;
		for (int i = 0; i < intArray.length; i++)
			sum += intArray[i];

		System.out.println("總合 = " + sum);
	}

}
