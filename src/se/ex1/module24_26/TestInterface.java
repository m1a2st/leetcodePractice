package se.ex1.module24_26;

//宣告介面
interface Display {
	// 宣告變數(常數) , 修飾子如同 public static final
	int num1 = 100;
	int num2 = 10;

	// 宣告方法(抽象方法) , 修飾子如同 public abstract
	void disp();
}

// 實作介面
class Plus implements Display {
	public void disp() {
		System.out.print(num1 + " + " + num2 + " = ");
		System.out.println(num1 + num2);
	}
}

// 實作介面
class Minus implements Display {
	public void disp() {
		System.out.print(num1 + " - " + num2 + " = ");
		System.out.println(num1 - num2);
	}
}

public class TestInterface {
	public static void main(String args[]) {
		Plus p1 = new Plus();
		p1.disp();
		Minus m1 = new Minus();
		m1.disp();
	}
}
