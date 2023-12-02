package se.ex2.module01_05;

public class TestThrowDemo {
	public static double method(double i, double j) throws ArithmeticException {
		double result;
		if (j == 0) {
			throw new ArithmeticException("喂! 除到0 ! 算數錯誤!");
		}
		result = i / j;
		return result;
	}

	public static void main(String[] args) {
		try {
			System.out.println(method(1, 0));
		} catch (ArithmeticException e) {
//			System.out.println(e.getMessage());
			// 或
			e.printStackTrace();
		}
	}

}
