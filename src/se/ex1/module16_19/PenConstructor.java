package se.ex1.module16_19;

public class PenConstructor {
	private String brand;
	private double price;
	
	public PenConstructor(String brand, double priceXXX) {
		this.brand = brand;
		price = priceXXX;
	}
	
	public static void main(String[] args) {
		PenConstructor pc = new PenConstructor("SKB", 10);
		System.out.println(pc.brand);
		System.out.println(pc.price);
	}
	
}
