package parctice.se.ex1.strategy.good;

public class DefendShield implements IDefendBehavior {

    @Override
    public void defend() {
        System.out.println("用盾牌格擋");
    }

}
