package se.ex1.module24_26;

// 筆類別(父類別)
// 抽象類別
abstract class Pen {
	protected String brand;
	protected double price;

	// 抽象方法
	public abstract void write();

	public void setdata(String brand, double price) {
		this.brand = brand;
		this.price = price;
	}
}

// 自訂的筆類別(子類別)
class MyPen extends Pen {
	// 定義抽象類別的動作
	public void write() {
		System.out.print("牌子是： " + brand);
		System.out.println("價格為： " + price);
	}
}

public class TestAbstract {
	public static void main(String args[]) {
		MyPen myPen = new MyPen();
		myPen.setdata("SKB", 10);
		myPen.write();
	}
}
