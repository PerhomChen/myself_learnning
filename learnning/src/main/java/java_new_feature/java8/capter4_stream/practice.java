package java_new_feature.java8.capter4_stream;

import java_new_feature.java8.Trader;
import java_new_feature.java8.Transaction;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.joining;


/**
 * @Author: Logan Chen
 * @date: 2019/10/28 10:02
 * @Description:
 */
public class practice {

    public static void main(String[] args) {

        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario", "Milan");
        Trader alan = new Trader("Alan", "Cambridge");
        Trader brian = new Trader("Brian", "Cambridge");

        List<Trader> traderList = Arrays.asList(raoul, mario, alan, brian);


        List<Transaction> transactions = Arrays.asList(
                new Transaction(brian, 2011, 300),
                new Transaction(raoul, 2012, 1000),
                new Transaction(raoul, 2011, 400),
                new Transaction(mario, 2012, 710),
                new Transaction(mario, 2012, 700),
                new Transaction(alan, 2012, 950)
        );

        //找出2011年发生的所有交易，并按交易额排序（从低到高）
        transactions.stream()
                .filter(a -> a.getYear() == 2011)
                .sorted(comparing(Transaction::getValue))
                .forEach(System.out::println);


        System.out.println("---------------------------------------------");

        //交易员都在哪些不同的城市工作过
        traderList.stream()
                .map(Trader::getCity)
                .distinct()   //也可toSet自动去重
                .forEach(System.out::println);

        System.out.println("---------------------------------------------");

        //查找所有来自剑桥的交易员并按姓名排序
        traderList.stream()
                .filter(c -> c.getCity() == "Cambridge")
                .sorted(comparing(Trader::getName))
                .forEach(System.out::println);

        System.out.println("---------------------------------------------");

        //返回所有交易员的姓名字符串并按字母顺序排序
        transactions.stream()
                .map(Transaction::getTrader)
                .map(Trader::getName)
                .distinct()
                .sorted()
                .reduce("", (n1, n2) -> n1 + n2);

        System.out.println();

        //第二种方法
        String ss = transactions.stream()
                .map(Transaction::getTrader)
                .map(Trader::getName)
                .distinct()
                .sorted()
                .collect(joining());  //joining在内部自动使用了stringbuilder，更为高效。

        System.out.println(ss);

        System.out.println("---------------------------------------------");

        //有没有交易员在米兰生活的
        Boolean b = transactions.stream().anyMatch(t -> t.getTrader().getCity().equals("Milan"));

        System.out.println(b);
        System.out.println("---------------------------------------------");

        //打印生活在剑桥的交易员的所有交易额
        transactions.stream()
                .filter(t -> t.getTrader()
                        .getCity().equals("Cambridge"))
                .map(Transaction::getValue)
                .sorted()
                .forEach(System.out::println);

        System.out.println("---------------------------------------------");

        //所有交易中，最高的交易额
        Optional<Integer> max = transactions.stream()
                .map(t -> t.getValue())
                .reduce(Integer::max);   //reduce归并操作;


        System.out.println(max);

        System.out.println("---------------------------------------------");

        //找到交易额最小的交易

        Optional<Transaction> minTransaction = transactions.stream().reduce((t1, t2) -> t1.getValue() < t2.getValue() ? t1 : t2);

        System.out.println(minTransaction.toString());

        //第二种方法

        Optional<Transaction> minTransaction1 = transactions.stream().min(comparing(Transaction::getValue));

        System.out.println(minTransaction1.toString());

        System.out.println("---------------------------------------------");

        /*综合使用*/
        //1-100以后符合勾股定理的三元组
        Stream<int[]> pythagoreanTriples =
                IntStream.rangeClosed(1, 100) //生成1-100（包含100）的随机整数
                        .boxed()   //int转换为Integer
                        .flatMap(a -> IntStream.rangeClosed(a, 100)    //避免重复的三元数
                                .filter(c -> Math.sqrt(a * a + c * c) % 1 == 0)
                                .mapToObj(c -> new int[]{a, c, (int) Math.sqrt(a * a + c * c)})
                        );

        pythagoreanTriples.limit(10).forEach(t -> System.out.println("(" + t[0] + "," + t[1] + "," + t[2] + ")"));

        System.out.println("---------------------------------------------");
        //更好的方法：先生成三元组，再筛选，上面的用了两次的

        Stream<double[]> pythagoreanTriples2 =
                IntStream.rangeClosed(1, 100).boxed()
                        .flatMap(a ->
                                IntStream.rangeClosed(a, 100)
                                        .mapToObj(
                                                c -> new double[]{a, c, Math.sqrt(a * a + c * c)})
                                        .filter(t -> t[2] % 1 == 0));

        pythagoreanTriples2.limit(10)
                .forEach(t -> System.out.println("(" + (int) t[0] + "," + (int) t[1] + "," + (int) t[2] + ")"));

        System.out.println("---------------------------------------------");

        /*构建流*/

        //由值构建流
        Stream<String> stream = Stream.of("java8 ", "lambda ", "in ", "Action");
        stream.map(String::toUpperCase).forEach(System.out::println);

        //使用empty得到一个空流
        Stream<String> emptyStram = Stream.empty();

        System.out.println("---------------------------------------------");

        //由数组创建流
        int[] numbers = {2, 3, 5, 7, 9, 11, 13};
        System.out.println("kotlin.basic.sum:" + Arrays.stream(numbers).sum());



        //由文件生成流；查看文件中有多少个不同的单词
        long uniqueWords = 0;

        try (Stream<String> lines =
                     Files.lines(Paths.get("C:\\Users\\chenph\\Downloads\\Document\\data.txt"), Charset.defaultCharset())) {
            uniqueWords = lines.flatMap(line -> Arrays.stream(line.split(""))) //
                    .distinct()
                    .count();
            System.out.println("words: " + uniqueWords);
        } catch (IOException e) {

        }

        System.out.println("---------------------------------------------");

        //使用函数生成无限流
        //iterate依次生成
        Stream.iterate(new int[]{0, 1},
                t -> new int[]{t[1],t[0] + t[1]})  //每一对都产生一个新数组
                .limit(10)
                .map(t -> t[0])
                .forEach(System.out::println);

        //使用generate;;如果不加limit将生成无限个。
        Stream.generate(Math::random).limit(5).forEach(System.out::println);

        

    }


}
