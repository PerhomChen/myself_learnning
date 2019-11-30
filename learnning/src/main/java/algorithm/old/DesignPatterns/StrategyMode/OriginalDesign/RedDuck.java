package DesignPatterns.StrategyMode.OriginalDesign;

import DesignPatterns.StrategyMode.OriginalDesign.Duck;

public class RedDuck extends Duck {
    @Override
    public void Quack() {
        super.Quack();
    }

    @Override
    public void display() {
        System.out.println("i am redDuck~~!");
    }

    @Override
    public void swim() {
        super.swim();
    }
}
