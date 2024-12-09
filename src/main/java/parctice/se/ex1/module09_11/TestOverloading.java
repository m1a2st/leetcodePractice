package parctice.se.ex1.module09_11;

/*
 * 此範例為方法多載的示範說明
 */
public class TestOverloading {

    // 圓形面積
    public static double areaMeasure(double radius) {
        return radius * radius * 3.14;
    }

    // 長方形面積
    public static double areaMeasure(double height, double width) {
        return height * width;
    }


    // 梯形面積
    public static double areaMeasure(double upper, double bottom, double height) {
        return (upper + bottom) * height / 2;
    }

    public static void main(String[] args) {
        double i = areaMeasure(3.0);
        double j = areaMeasure(3.0, 4.0);
        double k = areaMeasure(3.0, 4.0, 5.0);
        System.out.println("圓形面積=" + i);
        System.out.println("長方形面積=" + j);
        System.out.println("梯形面積=" + k);
    }

}
