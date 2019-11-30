package DesignPatterns.StrategyMode.StrategyModeDesign.duck;


import DesignPatterns.StrategyMode.StrategyModeDesign.FlyBehavior.NoFlyBehavior;

public class Test {
    public static void main(String[] args) {
        Duck duck = new RedDuck();
        Duck duck1 = new GreenDuck();
        duck.display();
        duck1.display();
        duck1.fly();
        duck.fly();
        duck1.quack();
        duck.quack();
        duck.setFlyBehavior(new NoFlyBehavior());
        duck1.setFlyBehavior(new NoFlyBehavior());
        System.out.println("#############");
        duck.fly();
        duck1.fly();
    }
}
