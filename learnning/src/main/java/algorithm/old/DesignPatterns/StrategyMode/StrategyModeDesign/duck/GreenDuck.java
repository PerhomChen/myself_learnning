package DesignPatterns.StrategyMode.StrategyModeDesign.duck;


import DesignPatterns.StrategyMode.StrategyModeDesign.FlyBehavior.BadFlyBehavior;
import DesignPatterns.StrategyMode.StrategyModeDesign.QuackBehavior.waQuack;

public class GreenDuck extends Duck {
    /**
     * 具体的行为在具体鸭子的构造器中再注入
     */
     public GreenDuck(){
        flyBehavior = new BadFlyBehavior();
        quackBehavior = new waQuack();
    }
    @Override
    public void display() {
        System.out.println("i am greenDuck~~!");
    }


}
