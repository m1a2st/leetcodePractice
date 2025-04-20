package practice.se.ex2.module37_42;

import java.util.List;
import java.util.function.UnaryOperator;

public class TestUnary {

    public static void main(String[] args) {
        List<Pen> penList = Pen.initPens();
        Pen pen = penList.get(penList.size() - 1);

        UnaryOperator<String> unaryStr =
                String::toUpperCase;

        System.out.println(unaryStr.apply(pen.getBrand()));

    }

}
