package main.java.parctice.se.ex1.strategy.good;

public class TestMain {

    public static void main(String[] args) {
        Poppy poppy = new Poppy("波比");
        poppy.setAttackBehavior(new AttackFire());
        poppy.setDefendBehavior(new DefendShield());
        poppy.setRunBehavior(new Run());

        poppy.attack();
        poppy.defend();
        poppy.run();
    }

}
