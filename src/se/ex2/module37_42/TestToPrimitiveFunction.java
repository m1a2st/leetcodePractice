package se.ex2.module37_42;

import java.util.List;
import java.util.function.ToDoubleFunction;
import java.util.function.ToIntFunction;

public class TestToPrimitiveFunction {

    public static void main(String[] args) {
        List<Pen> penList = Pen.initPens();
        Pen pen = penList.get(0);

        ToDoubleFunction<Pen> discountFunction =
                p -> p.getPrice() * 0.8;

        double discount = discountFunction.applyAsDouble(pen);
        System.out.println(discount);


        ToIntFunction<Pen> stockFunction =
                p -> p.getStock();

        int stock = stockFunction.applyAsInt(pen);
        System.out.println(stock);


    }

}
