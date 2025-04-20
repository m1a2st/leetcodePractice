package practice.se.ex1.module16_19;

public class PenConstructorThis {
    private final String brand;
    private final double price;

    public PenConstructorThis(String brand, double price) {
        this.brand = brand;
        this.price = price;
    }

    public static void main(String[] args) {
        PenConstructorThis pct = new PenConstructorThis("SKB", 10);
        System.out.println(pct.brand);
        System.out.println(pct.price);

    }

}
