package java_new_feature.java8.capter8_design_model;

/**
 * @Author: Logan Chen
 * @date: 2019/10/30 16:51
 * @Description:
 */
public class Factory {

    public static Product createProduct(String name) {
        switch (name){
            case "loan":return new Loan();
            case "stock":return new Stock();
            case "bond":return new Bond();
            default: throw new RuntimeException("No such Product " + name);
        }

    }
}

abstract class Product {

    String name;

    abstract void descriptionItself();

}

class Loan extends Product {

    public Loan(){
        this.name = "loan";
    }

    @Override
    void descriptionItself() {
        System.out.println("my name is " + name);
    }
}

class Stock extends Product {

    public Stock(){
        this.name = "Stock";
    }

    @Override
    void descriptionItself() {
        System.out.println("my name is " + name);
    }
}

class Bond extends Product {

    public Bond(){
        this.name = "Bond";
    }

    @Override
    void descriptionItself() {
        System.out.println("my name is " + name);
    }
}

class TestFactory{
    public static void main(String[] args) {
        Product p = Factory.createProduct("loan");
        p.descriptionItself();
    }
}

