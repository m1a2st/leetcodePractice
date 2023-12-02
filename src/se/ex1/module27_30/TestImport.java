package se.ex1.module27_30;

public class TestImport {

	public static void main(String[] args) {
		int[] intArray = {1, 3, 2, 0};
		java.util.Arrays.sort(intArray);
//		Arrays.sort(intArray);
		for(int i = 0; i < intArray.length; i++) {
			System.out.println(intArray[i]);
		}
	}

}
