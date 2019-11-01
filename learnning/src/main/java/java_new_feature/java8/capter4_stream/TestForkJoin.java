package java_new_feature.java8.capter4_stream;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.stream.LongStream;

/**
 * @Author: Logan Chen
 * @date: 2019/10/30 10:35
 * @Description:
 */
public class TestForkJoin {
    public static void main(String[] args) {

        //调用
        //...


    }

    //调用自定义的ForkJoinSumCalculator
    public static long forkJoinSum(long n){
        long[] numbers = LongStream.rangeClosed(1,n).toArray();
        //ForkJoinTask 是ForkJoinSumCalculator父类的父类。
        ForkJoinTask<Long> task = new ForkJoinSumCalculator(numbers);
        return new ForkJoinPool().invoke(task);
    }
}
