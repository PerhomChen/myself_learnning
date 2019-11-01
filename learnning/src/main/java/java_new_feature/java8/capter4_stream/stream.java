package java_new_feature.java8.capter4_stream;


import java_new_feature.java8.Dish;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.toList;

/**
 * @Author: Logan Chen
 * @date: 2019/10/26 11:59
 * @Description:
 */
public class stream {
    public static void main(String[] args) {

        Dish dish = new Dish(500, "cola","reg");
        Dish dish1 = new Dish(320, "ice","reg");
        Dish dish2 = new Dish(1200, "meat","meat");
        Dish dish3 = new Dish(200, "water","other");

        List<Dish> menu = Arrays.asList(dish, dish1, dish2, dish3);

        //你使用了一个垃圾变量，它唯一的作用就是作为一次性的中间容器。
        List<Dish> lowCaloricDishes = new ArrayList<>();
        //使用累加器筛选元素
        for (Dish d : menu) {
            if (d.getCalories() < 400) {
                lowCaloricDishes.add(d);
            }
        }
        //使用匿名类来进行排序
        Collections.sort(lowCaloricDishes, new Comparator<Dish>() {
            @Override
            public int compare(Dish o1, Dish o2) {
                return Integer.compare(o1.getCalories(), o2.getCalories());
            }
        });

        List<String> lowCaloricDishesName = new ArrayList<>();

        for (Dish d : lowCaloricDishes) {
            lowCaloricDishesName.add(d.getName());
        }

        for (String s : lowCaloricDishesName) {
            System.out.print(s + " ");
        }

        System.out.println();
        System.out.println("---------------------------------");

        //使用java8
        List<String> lowCaloricDishesNameNew = menu.stream()     //使用parallelStream开启多核
                .filter(d -> d.getCalories() < 400)  //过滤
                .sorted(comparing(Dish::getCalories))  //排序
                .map(Dish::getName)//提取菜单名称，map用于映射元素
                .limit(1)    //只返回一个，skip（n）与其互补
                .collect(toList());  //将所有的结果保存在list中

        for (String s : lowCaloricDishesNameNew) {
            System.out.print(s + " ");
        }

        System.out.println();
        System.out.println("-------------------------");


        //流只能被消费一次
        List<String> title = Arrays.asList("java8", "In", "Action");
        Stream<String> s = title.stream();
        s.forEach(a -> System.out.print(a + " "));
        //Exception in thread "main" java.lang.IllegalStateException: stream has already been operated upon or closed
        // s.forEach(System.out::println);
        System.out.println();
        System.out.println("-------------------------");

        /*flatMap*/
        //例子1：给定单词列表["Hello","World"]，你想要返回列表["H","e","l", "o","W","r","d"]。
        List<String> words = Arrays.asList("Hello","World");
        //因为string.split() 得到的是一个数组流，所以，最终得到的是流Stream<string[]>，我们对其distinct是没有起作用.
        //所以，我们希望得到的是字符流stream<string>然后可以对其distinct操作。
        //使用flatMap：各个数组并不是分别映射成一个流，而是映射成流的内容。所有使用map(Arrays::stream)时生成的单个流都被合并起来，
        // 即扁平化为一个流
        List<String[]> ret =  words.stream().map(w -> w.split("")).distinct().collect(toList()); //得到的结果是string[]


        List<String> uniqueCharacters =
                words.stream()
                        .map(w -> w.split(""))
                        .flatMap(Arrays::stream) //每个数组变成单独的流，再由flatMap合并为一个流。
                        .distinct()
                        .collect(Collectors.toList());

        for (String[] ss : ret) {
            for(int a = 0; a<ss.length;a++){
                System.out.print(ss[a] + ",");
            }
            System.out.print(";");

        }

        System.out.println();
        System.out.println("-------------------------");



        //例子2
        List<Integer> n1 = Arrays.asList(1, 2, 3);
        List<Integer> n2 = Arrays.asList(3, 4);
        List<int[]> pairs = n1.stream().flatMap(i -> n2.stream()
                                       .map(j -> new int[]{i, j}))
                                       .collect(toList());

        for (int[] jj : pairs) {
            System.out.print("(");
            for (int a = 0; a < jj.length ; a++) {
                System.out.print(jj[a] + ",");
            }
            System.out.print(");");
        }

        System.out.println();
        System.out.println("-------------------------");
        //返回能被3整除的数对
        List<int[]> pairsNew = n1.stream().flatMap(i -> n2.stream()
                                          .filter(j -> (i + j) % 3 == 0)
                                          .map(j -> new int[]{i,j}))
                                          .collect(toList());



        for (int[] jj : pairsNew) {
            System.out.print("(");
            for (int a = 0; a < jj.length ; a++) {
                System.out.print(jj[a] + ",");
            }
            System.out.print(");");
        }




    }

}


