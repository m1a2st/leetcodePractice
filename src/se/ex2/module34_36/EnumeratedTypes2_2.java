package se.ex2.module34_36;

/*更複雜的列舉定義
 底下示範了一個比較複雜的例子，由這個例子中可以看出，
 列舉其實只是一種比較特殊的類別，
 所以我們也才一直稱呼 enum 為列舉「型別」。
 它可以擁有自訂建構式、欄位以及方法，
*/

enum SuitB {
	spade("黑桃"), heart("紅心"), diamond("方塊"), club("梅花"), ;

	private String type; // 欄位

	SuitB(String type) { // 因為設定 club("梅花"), ..，所以必須要撰寫此一建構式
		this.type = type;
	}

	public String getType() { // 方法
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
}

public class EnumeratedTypes2_2 {
	public static void main(String[] args) {
		for (SuitB suit : SuitB.values()) {
			System.out.println(suit + "=" + suit.getType());
		} // spade=黑桃 heart=紅心 diamond=方塊 club=梅花

		SuitB suit = SuitB.spade;
		System.out.println(suit.getType()); // 黑桃
		suit.setType("※我是黑桃");
		System.out.println(suit.getType()); // ※我是黑桃
	}
}
