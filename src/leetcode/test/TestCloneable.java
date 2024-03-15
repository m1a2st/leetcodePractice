package leetcode.test;

import org.junit.jupiter.api.Test;

public class TestCloneable {

    @Test
    public void test() throws CloneNotSupportedException {
        Dog ck = new Dog(1, "CK");
        Object clone = ck.clone();
        System.out.println(ck);
        Object clone1 = clone;
        System.out.println(clone1.toString());
    }
}

class Dog implements Cloneable {
    int age;
    String name;

    public Dog(int age, String name) {
        this.age = age;
        this.name = name;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
