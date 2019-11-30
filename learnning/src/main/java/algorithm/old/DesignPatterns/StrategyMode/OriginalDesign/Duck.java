package DesignPatterns.StrategyMode.OriginalDesign;

public abstract class Duck {

    //叫方法
    public void Quack(){
        System.out.println("gaga~~~~!");
    }
    public abstract  void display();
    //swim method
    public void swim(){
        System.out.println("i am swimming~~!");
    }
}
