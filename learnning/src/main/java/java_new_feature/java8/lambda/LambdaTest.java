package java_new_feature.java8.lambda;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;


/**
 * @Author: Logan Chen
 * @date: 2019/10/25 9:57
 * @Description:
 */
public class LambdaTest {

    public static void main(String[] args) {
        Thread t = new Thread(() -> System.out.println("Hello world !"));
        t.run();

        //Runnable
        Runnable r = () -> System.out.println("i am runnable");
        r.run();

        //使用函数式接口
        try {
            String testOneLine = FileHandler.processFile((BufferedReader br) -> br.readLine());
            System.out.println(testOneLine);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            String testSecondLine = FileHandler.processFile((BufferedReader br) -> br.readLine() + br.readLine());
            System.out.println(testSecondLine);
        } catch (IOException e) {
            e.printStackTrace();
        }

        //使用forEach
        FileHandler.forEach(Arrays.asList(1, 2, 3, 4, 5), (Integer i) -> System.out.print(i + " "));

        //使用function
        FileHandler.map(Arrays.asList("lambdas","in","action"),(String s) -> s.length());
        System.out.println();


    }

}

class FileHandler {
    public static String processFile(BufferedReaderProcessor p) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\chenph\\Downloads\\Document\\data.txt"))) {
            return p.process(br);
        }
    }

    //利用consumer函数式接口定义可根据传入的对数组的处理方式而执行不同操作的forEach
    public static <T> void forEach(List<T> list, Consumer<T> c) {
        for (T t : list) {
            c.accept(t);
        }
    }

    //使用Function函数式接口,接收一个T输入，返回一个R输出。
    //需求，把映射后的R作为map的T
    //<T,R>表明该方法将使用泛型类型T、R，此时才可以在方法中使用泛型类型T、R。因为类定义的时候并没有加泛型
    public static <T, R> List<R> map(List<T> list, Function<T, R> f) {
        List<R> ret = new ArrayList<>();
        for (T t : list) {
            ret.add(f.apply(t));
        }
        return ret;
    }
}