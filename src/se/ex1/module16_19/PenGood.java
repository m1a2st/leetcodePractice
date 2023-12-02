package se.ex1.module16_19;
/*
 * 正確的資料封裝處理示範
 * 將商業邏輯放在getter/setter方法裡
 * 可確保資料操作安全與正確性
 */
public class PenGood {
	private String brand;
	private double price;

	public PenGood() {
	}

	public PenGood(String brandXXX, int priceXXX) {
		setBrand(brandXXX);
		setPrice(priceXXX);
	}
	
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brandXXX) {
		brand = brandXXX;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double priceXXX) {
		if(priceXXX > 0)
			price = priceXXX;
		else
			System.out.println("請確認售價設定");
	}
}
