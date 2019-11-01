package java_new_feature.java8.capter4_stream;

import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;

import static java.util.stream.Collector.Characteristics.CONCURRENT;
import static java.util.stream.Collector.Characteristics.IDENTITY_FINISH;


/**
 * @Author: Logan Chen
 * @date: 2019/10/29 15:27
 * @Description:
 */
public class ToListCollector<T> implements Collector<T,List<T>, List<T>> {


    //创建集合操作的起始点
    @Override
    public Supplier<List<T>> supplier() {
        return ArrayList::new;
    }

    //累积遍历过的项目，原位修改累加器
    @Override
    public BiConsumer<List<T>, T> accumulator() {
        return List::add;
    }

    //恒等函数
    @Override
    public Function<List<T>, List<T>> finisher() {
        return Function.identity();
    }



    //归约操作
    @Override
    public BinaryOperator<List<T>> combiner() {
        return (list1,list2) -> {
            list1.addAll(list2);
            return list1;
        } ;
    }


    //为收集器添加特性
    @Override
    public Set<Characteristics> characteristics() {
        return Collections.unmodifiableSet(EnumSet.of(IDENTITY_FINISH,CONCURRENT));
    }
}
