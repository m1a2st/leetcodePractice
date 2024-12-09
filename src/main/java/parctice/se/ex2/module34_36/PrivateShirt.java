package parctice.se.ex2.module34_36;

public class PrivateShirt {

    private final int shirtID = 0;
    private final String description = "-description required-";
    // ● 顏色碼 R=紅色, B=藍色, G=綠色, U=未定
    private char colorCode = 'U';
    private final double price = 0.0;
    private final int quantityInStock = 0;

    // ●getXxx
    public char getColorCode() {
        return colorCode;
    }

    // ●setXxx
    public void setColorCode(char newCode) {
        switch (newCode) {
            case 'R':
            case 'G':
            case 'B':
                colorCode = newCode;
                break;
            default:
                System.out.println("不正確的顏色碼. 請使用 R, G, or B");
        }
    }
    // ※ 其它對 shirtID, description,
    // ※ price, and quantityInStock 的 get set方法, 請仿照上述的作法
}
