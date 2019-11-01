package java_new_feature.java8.capter8_design_model;

import org.jetbrains.annotations.TestOnly;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

/**
 * @Author: Logan Chen
 * @date: 2019/10/30 17:00
 * @Description:
 */
public class Factory_lambda {

    //创建一个Map，将product名称映射到对应的构造函数
    //Supplier接收一个空，返回T
    final static Map<String, Supplier<Product>> map = new HashMap<>();

    static {
        /*lambda方式重构工厂模式*/
        map.put("loan", Loan::new);
        map.put("stock", Stock::new);
        map.put("bond", Bond::new);
    }

    public static void main(String[] args) throws IllegalAccessException {
        //使用lambda调用构造函数
        Supplier<Product> loanSupplier = Loan::new;
        Loan loan = (Loan) loanSupplier.get();

        //调用
        Product p = createProduct("stock");
        p.descriptionItself();


    }

    public static Product createProduct(String name) throws IllegalAccessException {

        Supplier<Product> product = map.get(name);
        //调用get的时候执行
        if (product != null)
            return product.get();

        throw new IllegalAccessException("No such product " + name);
    }



}
