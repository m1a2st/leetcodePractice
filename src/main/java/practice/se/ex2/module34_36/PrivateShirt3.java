package practice.se.ex2.module34_36;

public class PrivateShirt3 {
    private final int shirtID = 0;
    private final String description = "-description required-";
    // ● 顏色碼 R=紅色, B=藍色, G=綠色, U=未定
    private ColorCode2 colorCode = ColorCode2.U;
    private final double price = 0.0;
    private final int quantityInStock = 0;

    // ●getXxx
    public ColorCode2 getColorCode2() {
        return colorCode;
    }

    // ●setXxx
    public void setColorCode2(ColorCode2 newCode) {
        colorCode = newCode;
        // ※不再需要此錯誤處理了, 已由 enum 決定範圍了
    }
    // ※ 其它對 shirtID, description,
    // ※ price, and quantityInStock 的 get set方法, 請仿照上述的作法
}
