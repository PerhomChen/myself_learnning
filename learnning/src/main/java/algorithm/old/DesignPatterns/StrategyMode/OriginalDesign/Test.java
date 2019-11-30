package DesignPatterns.StrategyMode.OriginalDesign;

public class Test {
    public static void main(String[] args) {
        Duck duck = new RedDuck();
        Duck duck1 = new GreenDuck();
        duck.display();
        duck1.display();
    }
}
