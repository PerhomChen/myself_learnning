package java_new_feature.java8.future;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

/**
 * @Author: Logan Chen
 * @date: 2019/10/31 15:29
 * @Description:
 */
public class FutureTest {
    public static void main(String[] args) {

        //创建ExecutorService，通过它，你可以向线程池提交任务
        ExecutorService executor = Executors.newCachedThreadPool();
        Future<Double> futureTest = executor.submit(new Callable<Double>() {
            public Double call() {
                return null;
            }
        });


        //使用异步API
        Shop shop = new Shop("BestShop");
        long start = System.nanoTime();
        Future<Double> futurePrice = shop.getPriceAsync("my favorite product");
        long invocationTime = ((System.nanoTime() - start) /1_000_000); //1s
        System.out.println("Invocation returned after " + invocationTime + " msecs");

        //执行更多的任务

        //在计算商品价格的同时
        try {
            double price = futurePrice.get();
            System.out.printf("Price is %.2f%n",price);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        long retrievalTime = ((System.nanoTime() - start) / 1_000_000);
        System.out.println("Price returned after " + retrievalTime + " msecs");

    }







}

class Shop {



    private String name ;

    public Shop(String name){
        this.name = name;
    }


    public double getPrice(String product){
        return 0;
    }

    public Future<Double> getPriceAsync(String product){
        //创建CompletableFuture，它会包含计算的结果
        CompletableFuture<Double> futurePrice = new CompletableFuture<>();
        //在另一个线程中以异步的方式执行计算
        new Thread(() -> {
            try {
                double price = calculatePrice(product);
                //需要长时间计算的任务结束并得出结果时，设置Future的返回值。
                futurePrice.complete(price);
            } catch (Exception e) {
                //将CompletableFuture的异常抛出
                futurePrice.completeExceptionally(e);
            }
        }).start();
        //无需等待还没结束的计算，直接返回Future对象。
        return futurePrice;
    }

    //使用工厂方法supplyAsync创建CompletableFuture对象
    public Future<Double> getPriceAsync_factory(String product){
        return CompletableFuture.supplyAsync(() -> calculatePrice(product));
    }





    private double calculatePrice(String product) {
        delay();
        Random random = new Random();
        return random.nextDouble() * product.charAt(0) + product.charAt(1);
    }


    public static void delay() {
        try {
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    /*public List<String> findPrices(String product) {
        List<CompletableFuture<String>> priceFutures =
                shops.stream()
                        .map(shop -> CompletableFuture.supplyAsync(
                                () -> shop.getName() + " price is " +
                                        shop.getPrice(product)))
                        .collect(toList());
        return priceFutures.stream()
                .map(CompletableFuture::join)
                .collect(toList());
    }*/

}


class test1 {
    public static void main(String[] args) {
        new Random().ints(1,81).limit(10).forEach(System.out::println);
    }
}