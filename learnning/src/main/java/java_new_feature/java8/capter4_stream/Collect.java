package java_new_feature.java8.capter4_stream;


import java_new_feature.java8.CaloricLevel;
import java_new_feature.java8.Dish;

import java.util.*;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.*;


/**
 * @Author: Logan Chen
 * @date: 2019/10/28 18:08
 * @Description:
 */
public class Collect {
    public static void main(String[] args) {

        Dish dish = new Dish(500, "cola", "reg");
        Dish dish1 = new Dish(320, "ice", "reg");
        Dish dish2 = new Dish(1200, "meat", "meat");
        Dish dish3 = new Dish(200, "water", "other");

        List<Dish> menu = Arrays.asList(dish, dish1, dish2, dish3);

        //新建比较器
        Comparator<Dish> dishComparator = Comparator.comparingInt(Dish::getCalories);

        //maxBy收集器接收一个比较器比较流中的元素；tolist也是一个收集器；groupingBy也是
        Optional<Dish> mostDish = menu.stream().collect(maxBy(dishComparator));

        System.out.println(mostDish.toString());


        /*分组：*/
        //groupingBy，自定义分组函数
        Map<CaloricLevel, List<Dish>> dishesByCaloricLevel = menu.stream().collect(
                groupingBy(di -> {
                    if (di.getCalories() <= 400) return CaloricLevel.DIET;
                    else if (di.getCalories() <= 700) return CaloricLevel.NORMAL;
                    else return CaloricLevel.FAT;
                })
        );

        //通用map迭代方法
        System.out.println("-----------通用map迭代方法-------------");
        for (Map.Entry<CaloricLevel, List<Dish>> entry : dishesByCaloricLevel.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());

        }

        System.out.println("-----------------jdk8 for each--------------");

        dishesByCaloricLevel.forEach((key, value) -> System.out.println(key + ": " + value));

        System.out.println("-------------------------------");


        //使用groupingBy联合其他收集器使用的例子
        Map<String, Integer> totalCaloriesByType =
                menu.stream()
                        .collect(groupingBy(Dish::getType, summingInt(Dish::getCalories)));

        totalCaloriesByType.forEach((key, value) -> System.out.println(key + ": " + value));
        System.out.println("-------------------------------");

        //groupingBy和mapping联合使用
        Map<String, Set<CaloricLevel>> caloricLevelsByType =
                menu.stream().collect(
                        groupingBy(Dish::getType, mapping(
                                di -> {
                                    if (di.getCalories() <= 400) return CaloricLevel.DIET;
                                    else if (di.getCalories() <= 700) return CaloricLevel.NORMAL;
                                    else return CaloricLevel.FAT;
                                }, toSet()
                        ))
                );

        caloricLevelsByType.forEach((key, value) -> System.out.println(key + ":" + value));

        System.out.println("-------------------------------");

        //an数字按质数和非质数分区

        Collect collect = new Collect();
        Map<Boolean, List<Integer>> rett = collect.partitionPrimes(100);
        rett.forEach((key, value) -> System.out.println(key + ": " + value));

        System.out.println("----------------------------------");

        Map<Boolean, List<Integer>> newRet = collect.partitionPrimesWithCustomCollector(100);

        newRet.forEach((key, value) -> System.out.println(key + ": " + value));

    }

    //判断是否为质数的方法。
    public boolean isPrime(int candidate) {
        int candidateRoot = (int) Math.sqrt((double) candidate);
        return IntStream.rangeClosed(2, (int) candidateRoot).noneMatch(i -> candidate % i == 0);  //整除就包含这个

    }

    /**
     * @Description: 根据传进来的n，生成是0-n范围内，分组为是否为质数的列表。
     * @Params: [n]
     * @return: java.util.Map<java.lang.Boolean, java.util.List < java.lang.Integer>>
     * @Author: Logan Chen
     * @Time: 2019/10/29 14:16
     * @Change:
     */
    public Map<Boolean, List<Integer>> partitionPrimes(int n) {
        return IntStream.rangeClosed(2, n).boxed()
                .collect(partitioningBy(candidate -> isPrime(candidate)));
    }

    public Map<Boolean, List<Integer>> partitionPrimesWithCustomCollector(int n) {
        return IntStream.rangeClosed(2, n).boxed()
                .collect(new PrimeNumbersCollector());
    }

}


