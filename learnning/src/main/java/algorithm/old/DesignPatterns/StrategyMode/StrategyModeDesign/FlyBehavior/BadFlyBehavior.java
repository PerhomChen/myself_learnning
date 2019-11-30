package DesignPatterns.StrategyMode.StrategyModeDesign.FlyBehavior;

public class BadFlyBehavior implements FlyBehavior{
    @Override
    public void fly() {
        System.out.println("bad fly~~!");
    }
}
