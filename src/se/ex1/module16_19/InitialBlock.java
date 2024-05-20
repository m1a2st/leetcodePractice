package se.ex1.module16_19;

public class InitialBlock {
    private String brand;
    private double price;
    private static final int amount;
	
	/* Java會在編譯時自動加入初始區塊，目的是將實體變數(屬性)的初始值建立好
	 * 如果類別裡有靜態變數，會自動加入靜態初始區塊，目的一樣
	   {
		 name = null;
		 price = 0.0;
	   }
	
	   static {
		 amount = 0;
	   }
	*/

    // 我們也能自行建立初始區塊，用來定義初始值或是有些需要先執行的內容
    // 但執行的先後順序一定是Java預設的初始區塊先執行，再來才執行我們定義的區塊內容
    {
        price = 10.0;
//		amount = 10;   //OK
        System.out.println("Hello");
    }

    // 我們也能自行建立static初始區塊，用來定義static初始值或是有些需要先執行的內容
    // 但執行的先後順序一定是Java預設的初始區塊先執行，再來才執行我們定義的區塊內容
    static {
        amount = 10;
//		price = 20.0;  // NG, static區塊裡只能有static變數
    }

    //建構式
    public InitialBlock(String brand, double price) {
        this.brand = brand;
        this.price = price;
        System.out.println("Here is Constructor");
    }

    public InitialBlock() {
    }


    /*
     * 總結：
     * 1. Java為了給實體變數跟static變數初始值，所以會在編譯時自動加入初始區塊設定初始值
     * 2. 設計上若是有些內容想要先執行或是先指定初始值時，可以再自行加入區塊 (不常用)
     * 3. 物件產生的程式執行順序 (Java預設區塊 → 自行定義區塊 → 建構式)
     */

    public static void main(String[] args) {
//		InitialBlock ib = new InitialBlock();
        InitialBlock ib = new InitialBlock("SKB", 10);
        System.out.println(ib.brand);
        System.out.println(ib.price);
        System.out.println(InitialBlock.amount);
    }


}
