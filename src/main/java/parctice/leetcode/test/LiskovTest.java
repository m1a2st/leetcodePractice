package parctice.leetcode.test;

public class LiskovTest {

    public Cat feed(Cat cat) {
        System.out.println("feed cat");
        return cat;
    }
}

class LiskovTest2 extends LiskovTest {

}


class Animal {

}

class Cat extends Animal {

}

class BlackCat extends Cat {

}
