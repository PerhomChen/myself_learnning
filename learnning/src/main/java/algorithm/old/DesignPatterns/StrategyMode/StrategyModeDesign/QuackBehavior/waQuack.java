package DesignPatterns.StrategyMode.StrategyModeDesign.QuackBehavior;

public class waQuack implements QuackBehavior {
    @Override
    public void quackBehavior() {
        System.out.println("wawawa~~~!");
    }
}
