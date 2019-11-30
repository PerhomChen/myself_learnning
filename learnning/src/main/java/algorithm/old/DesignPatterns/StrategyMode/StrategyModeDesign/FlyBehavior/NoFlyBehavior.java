package DesignPatterns.StrategyMode.StrategyModeDesign.FlyBehavior;

public class NoFlyBehavior implements FlyBehavior{
    @Override
    public void fly() {
        System.out.println("no fly~~!");
    }

}
