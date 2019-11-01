package java_new_feature.java8.methodRef;

import java_new_feature.java8.methodRef.Apple;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

import static java.util.Comparator.comparing;

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

        for (Apple apple : appleList) {
            System.out.println(apple.toString());
        }

        System.out.println("----------------------");

        //使用方法调用的方式插入方法作为过滤条件。
        // appleList = Apple.filterApple(appleList,Apple::isGreenApple);
        //在这个场景下，使用匿名函数更好，因为这个方法不常用
        appleList = Apple.filterApple(appleList, (Apple a) -> "green".equals(a.getColor()));

        for (Apple apple : appleList) {
            System.out.println(apple.toString());
        }

        System.out.println("----------------------");

        //appleList = Apple.filterApple(appleList,Apple::isHeavyApple);
        appleList = Apple.filterApple(appleList, (Apple a) -> a.getHeavy() > 150);

        for (Apple apple : appleList) {
            System.out.println(apple.toString());
        }


    }
}

class MethodRef2 {
    public static void main(String[] args) {
        List<Apple> appleList = new ArrayList<>();
        Apple apple1 = new Apple();
        apple1.setColor("red");
        apple1.setHeavy(180);

        Apple apple4 = new Apple();
        apple4.setColor("aellow");
        apple4.setHeavy(180);
        Apple apple2 = new Apple();
        apple2.setColor("green");
        apple2.setHeavy(1844);
        Apple apple3 = new Apple();
        apple3.setColor("green");
        apple3.setHeavy(120);

        appleList = Arrays.asList(apple1, apple2, apple3, apple4);

        //应用匿名类
        //  ni(appleList);


        //  lambda(appleList);

        //   lambda1(appleList);

        //方法引用：
        appleList.sort(comparing(Apple::getHeavy));

        for (Apple apple : appleList) {
            System.out.println(apple.toString());
        }

        System.out.println("---------------------------");

        addLambda(appleList);


        //函数复合
        Function<Integer, Integer> f = x -> x + 1;
        Function<Integer, Integer> g = x -> x * 2;
        Function<Integer, Integer> h = f.andThen(g);  //相当于g(f(x))
        System.out.println(h.apply(1));

        Function<Integer, Integer> i = f.compose(g);  //相当于f(g(x))
        System.out.println(i.apply(1));

        System.out.println("---------------------------");


        isComplex(appleList);

    }


    //使用匿名类
    public static void ni(List<Apple> list) {
        list.sort(new Comparator<Apple>() {
            @Override
            public int compare(Apple o1, Apple o2) {
                //只能对引用类型进行排序
                return o1.getHeavy().compareTo(o2.getHeavy());
            }
        });

        for (Apple apple : list) {
            System.out.println(apple.toString());
        }

        System.out.println("---------------------------");
    }

    public static void lambda(List<Apple> list) {
        list.sort((a1, a2) -> a1.getHeavy().compareTo(a2.getHeavy()));

        for (Apple apple : list) {
            System.out.println(apple.toString());
        }

        System.out.println("---------------------------");
    }

    //Comparator有一个comparing的静态辅助方法，它可以接受一个Function来提取Comparable键值，并生成一个Comparator对象
    public static void lambda1(List<Apple> list) {
        list.sort(comparing((a) -> a.getHeavy()));

        for (Apple apple : list) {
            System.out.println(apple.toString());
        }

        System.out.println("---------------------------");
    }

    //比较器复合
    public static void addLambda(List<Apple> list) {
        //逆序
        list.sort(comparing(Apple::getHeavy).reversed());
        for (Apple apple : list) {
            System.out.println(apple.toString());
        }

        System.out.println("---------------------------");

        //比较器链
        list.sort(comparing(Apple::getHeavy).reversed().thenComparing(Apple::getColor));

        list.sort(comparing(Apple::getHeavy).reversed());
        for (Apple apple : list) {
            System.out.println(apple.toString());
        }

        System.out.println("---------------------------");
    }

    //谓词复合:negate、and、or
    public static void isComplex(List<Apple> list) {

        Predicate<Apple> redApple = a -> "red".equals(a.getColor());

        List<Apple> list1 =  Apple.filterApple(list,redApple);

        for (Apple apple : list1) {
            System.out.println(apple.toString());
        }

        System.out.println("-------red--------------------");


        //挑选苹果颜色不为红的;negate::非
        Predicate<Apple> notRedApple = redApple.negate();
        List<Apple> list2 =  Apple.filterApple(list,notRedApple);
        for (Apple apple : list2) {
            System.out.println(apple.toString());
        }

        System.out.println("-----------not red----------------");
        //and 并且
        Predicate<Apple> redandHeavyApple = redApple.and(a -> a.getHeavy() > 150);
        List<Apple> list3 = Apple.filterApple(list,redandHeavyApple);
        for (Apple apple : list3) {
            System.out.println(apple.toString());
        }

        System.out.println("-------------red heavy--------------");
        //or  或
        Predicate<Apple> redandHeavyAppleOrGreen = redApple.and(a -> a.getHeavy() > 150).or(a -> "green".equals(a.getColor()));
        List<Apple> list4 = Apple.filterApple(list,redandHeavyAppleOrGreen);
        for (Apple apple : list4) {
            System.out.println(apple.toString());
        }

        System.out.println("-------------red heavy or green--------------");




    }

}
