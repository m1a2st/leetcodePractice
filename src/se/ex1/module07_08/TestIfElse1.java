package se.ex1.module07_08;
/*
 * 此範例為程式流程制控(if - else)使用範例
 */
public class TestIfElse1 {

	public static void main(String[] args) {
		int a = 10;

		if (a == 10) {
			System.out.println("a 的值是 10");  //因為條件成立，故會執行
		}

		if (a == 20) {
			System.out.println("a 的值是 20");
		} else {
			System.out.println("a 的值不是 20");  //因為條件成立，故會執行
		}

		if (a == 20) {
			System.out.println("a 的值是 20");
		} else if (a == 30) {
			System.out.println("a 的值是 30");
		} else {
			System.out.println("a 的值不是 20 也不是 30");  //因為條件成立，故會執行
		}
		
	}

}
