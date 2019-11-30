package DesignPatterns.StrategyMode.StrategyModeDesign.duck;


import DesignPatterns.StrategyMode.StrategyModeDesign.FlyBehavior.GoodFlyBehavior;
import DesignPatterns.StrategyMode.StrategyModeDesign.QuackBehavior.gaQuack;

public class RedDuck extends Duck {

    public RedDuck(){
        flyBehavior = new GoodFlyBehavior();
        quackBehavior = new gaQuack();
    }

    @Override
    public void display() {
        System.out.println("i am redDuck~~!");
    }


}
