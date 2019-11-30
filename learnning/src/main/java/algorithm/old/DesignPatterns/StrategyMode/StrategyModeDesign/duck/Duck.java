package DesignPatterns.StrategyMode.StrategyModeDesign.duck;

import DesignPatterns.StrategyMode.StrategyModeDesign.FlyBehavior.FlyBehavior;
import DesignPatterns.StrategyMode.StrategyModeDesign.QuackBehavior.QuackBehavior;

public abstract class Duck {

    //Quack
    QuackBehavior quackBehavior;
    public void quack(){
        quackBehavior.quackBehavior();
    }
    //fly
    FlyBehavior flyBehavior;
    public void fly(){
        flyBehavior.fly();
    }

    public abstract  void display();

    /**
     * add setter for behavior,so can change specific behavior dynamic
     */
    public void setQuackBehavior(QuackBehavior quackBehavior) {
        this.quackBehavior = quackBehavior;
    }

    public void setFlyBehavior(FlyBehavior flyBehavior) {
        this.flyBehavior = flyBehavior;
    }
}
