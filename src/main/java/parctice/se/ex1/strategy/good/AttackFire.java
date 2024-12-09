package main.java.parctice.se.ex1.strategy.good;

public class AttackFire implements IAttackBehavior {

    @Override
    public void attack() {
        System.out.println("技能 - 點燃");
    }

}
