package java_new_feature.java8.methodRef;

import java_new_feature.java8.methodRef.Apple;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Logan Chen
 * @date: 2019/10/24 16:42
 * @Description:
 */
public class MethodRef {

    public static void main(String[] args) {

        List<Apple> appleList = new ArrayList<>();
        Apple apple1 = new Apple();
        apple1.setColor("red");
        apple1.setHeavy(180);
        Apple apple2 = new Apple();
        apple2.setColor("green");
        apple2.setHeavy(1844);
        Apple apple3 = new Apple();
        apple3.setColor("green");
        apple3.setHeavy(120);

        appleList.add(apple1);
        appleList.add(apple2);
        appleList.add(apple3);

        for(Apple apple : appleList){
            System.out.println(apple.toString());
        }

        System.out.println("----------------------");

        //使用方法调用的方式插入方法作为过滤条件。
        // appleList = Apple.filterApple(appleList,Apple::isGreenApple);
        //在这个场景下，使用匿名函数更好，因为这个方法不常用
        appleList = Apple.filterApple(appleList,(Apple a) -> "green".equals(a.getColor()));
  
        for(Apple apple : appleList){
            System.out.println(apple.toString());
        }

        System.out.println("----------------------");

        //appleList = Apple.filterApple(appleList,Apple::isHeavyApple);
        appleList = Apple.filterApple(appleList,(Apple a) -> a.getHeavy() > 150);

        for(Apple apple : appleList){
            System.out.println(apple.toString());
        }



    }
}
