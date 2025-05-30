package practice.se.ex2.module37_42;

import java.util.List;
import java.util.function.Supplier;

public class TestSupplier {

    public static void main(String[] args) {
        List<Pen> penList = Pen.initPens();

        Supplier<Pen> penSupplier =
                () -> new Pen.Builder()
                        .setBrand("LION")
                        .setPrice(12)
                        .setStock(70)
                        .setColor(Color.BLACK)
                        .setCanErase(true)
                        .build();

        penList.add(penSupplier.get());
        penList.forEach(Pen::printDetails); //方法參考， 在lambda語法裡對方法呼叫更加簡化
        //penList.forEach(p -> )
    }

}
