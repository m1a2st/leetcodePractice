package se.ex2.module34_36;

/*更複雜的列舉定義
 底下示範了一個比較複雜的例子，由這個例子中可以看出，
 列舉其實只是一種比較特殊的類別，
 所以我們也才一直稱呼 enum 為列舉「型別」。
 它可以擁有自訂建構式、欄位以及方法，
*/

enum SuitA {
	club(1), diamond(2), heart(3), spade(4);

	private int value; // 欄位

	SuitA(int value) { // 因為設定 club(1), ..，所以必須要撰寫此一建構式
		this.value = value;
	}

	public int getValue() { // 方法
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}
}

public class EnumeratedTypes2_1 {
	public static void main(String[] args) {
		for (SuitA suit : SuitA.values()) {
			System.out.println(suit + "=" + suit.getValue());
		}
		SuitA suit = SuitA.diamond;
		System.out.println(suit.getValue());
		suit.setValue(10);
		System.out.println(suit.getValue());
	}
}
