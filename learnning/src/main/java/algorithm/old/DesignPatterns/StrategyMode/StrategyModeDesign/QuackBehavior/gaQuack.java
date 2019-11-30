package DesignPatterns.StrategyMode.StrategyModeDesign.QuackBehavior;

public class gaQuack implements QuackBehavior {

    @Override
    public void quackBehavior() {
        System.out.println("gaga~~~!");
    }
}
