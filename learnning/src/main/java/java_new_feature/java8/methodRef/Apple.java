package java_new_feature.java8.methodRef;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

/**
 * @Author: Logan Chen
 * @date: 2019/10/24 16:37
 * @Description:
 */
@Data
public class Apple {

    private String color;

    private Integer heavy;

    public static boolean isGreenApple(Apple apple) {
        return "green".equals(apple.getColor());
    }

    public static boolean isHeavyApple(Apple apple) {
        return apple.getHeavy() > 150;
    }

    static List<Apple> filterApple(List<Apple> inventory, Predicate<Apple> p) {
        List<Apple> ret = new ArrayList<>();
        for (Apple apple : inventory) {
            if (p.test(apple)) {
                ret.add(apple);
            }
        }
        return ret;
    }
}
