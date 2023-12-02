package se.ex2.module13_17;

public class EnhanceForArray {

	public static void main(String[] args) {
		float farray[] = { 1.0f, 2.0f, 3.0f, 4.0f, 5.0f };

		System.out.println("傳統的for 迴圈");
		for (int i = 0; i < farray.length; i++)
			System.out.print(farray[i] + ", ");
		System.out.println('\n');

		System.out.println("增強功能的 for 迴圈(Using Enhanced foreach)");
		for (float xx : farray)
			System.out.print(xx + ", ");
		System.out.println();
	}

}
