package java_new_feature.java8.capter4_stream;

import java.util.concurrent.RecursiveTask;

/**
 * @Author: Logan Chen
 * @date: 2019/10/30 10:18
 * @Description: 自定义的分支/合并框架
 */
public class ForkJoinSumCalculator extends RecursiveTask<Long> {

    //实例变量
    private final long[] numbers;
    private final int start;
    private final int end;

    public static final long THRESHOLD = 10_000;

    public ForkJoinSumCalculator(long[] numbers) {
        this(numbers, 0, numbers.length);
    }

    private ForkJoinSumCalculator(long[] numbers, int start, int end) {
        this.numbers = numbers;
        this.start = start;
        this.end = end;
    }

    //这里定义任务怎么划分，划分到什么条件不继续划分。
    @Override
    protected Long compute() {
        int length = end - start;
        //如果<阈值，返回顺序计算结果
        if (length <= THRESHOLD) {
            return computeSequentially();
        }
        ForkJoinSumCalculator leftTask = new ForkJoinSumCalculator(numbers, start, length / 2);
        leftTask.fork();
        ForkJoinSumCalculator rightTask = new ForkJoinSumCalculator(numbers, start + length / 2, end);
        rightTask.fork();
        Long rightResult = rightTask.compute();
        Long leftResult = leftTask.compute();

        return rightResult + leftResult;
    }

    //顺序计算结果的方法，start，end，numbers在该类初始化的时候就已经赋值了，可以直接使用
    private long computeSequentially() {
        long sum = 0;
        for (int i = start; i < end; i++) {
            sum += numbers[i];
        }
        return sum;
    }


}
