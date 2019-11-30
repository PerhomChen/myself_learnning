package DesignPatterns.StrategyMode.OriginalDesign;

import DesignPatterns.StrategyMode.OriginalDesign.Duck;

public class GreenDuck extends Duck {
    @Override
    public void Quack() {
        super.Quack();
    }

    @Override
    public void display() {
        System.out.println("i am greenDuck~~!");
    }

    @Override
    public void swim() {
        super.swim();
    }
}
