package se.ex2.module34_36;

public class PrivateShirtTest2 {

	public static void main(String args[]) {

		PrivateShirt2 privShirt = new PrivateShirt2();
		ColorCode colorCode;

		// 1. 設定合法的顏色碼'R'
		// 2. 設定不合法的顏色碼時, 即compile error , 因已由 enum 決定範圍了
		// 3. 已達成在編譯階段就可檢查所設定的列舉式資料是否合法的目的!
		privShirt.setColorCode(ColorCode.R);
		System.out.println("Color Code: " + privShirt.getColorCode());

	}
}
