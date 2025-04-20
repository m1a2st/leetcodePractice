package practice.se.ex2.module18_20;

import java.util.Stack;

public class Test_LIFO_Stack {
    public static void main(String[] args) {
        Stack list = new Stack();
        list.add("c");
        list.add("a");
        list.add("b");
        list.add("a");
        System.out.println(list);

        for (int i = 0; i < list.size(); i++)
            System.out.println(list.get(i));

        System.out.println();

        while (!list.empty())
            System.out.println(list.pop());

    }
}
