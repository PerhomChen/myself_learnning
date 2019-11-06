package java_new_feature.java8.future;

import org.jetbrains.annotations.NotNull;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

import static java.util.stream.Collectors.toList;

/**
 * @Author: Logan Chen
 * @date: 2019/11/1 16:35
 * @Description:
 */
public class exmple {

    List<Shop> shops = Arrays.asList(new Shop("BestPrice"),
            new Shop("LetsSaveBig"),
            new Shop("MyFavoriteShop"),
            new Shop("BuyItAll"));

    //if counts =5
    List<Shop> shops1 = Arrays.asList(new Shop("BestPrice"),
            new Shop("LetsSaveBig"),
            new Shop("MyFavoriteShop"),
            new Shop("itShop"),
            new Shop("itShop1"),
            new Shop("itShop2"),
            new Shop("itShop3"),
            new Shop("itShop4"),
            new Shop("itShop5"),
            new Shop("itShop6"),
            new Shop("itShop7"),
            new Shop("itShop8"),
            new Shop("BuyItAll"));

    //自定制的执行器
    //创建一个守护线程构成的线程池，线程池中线程的数目为100和商店数量的最小值
    private final Executor executor = Executors.newFixedThreadPool(Math.min(shops1.size(), 100), new ThreadFactory() {
        @Override
        public Thread newThread(@NotNull Runnable r) {
            Thread t = new Thread(r);
            //使用守护线程。是非守护线程的保姆。
            t.setDaemon(true);
            return t;
        }
    });


    @Test
    public void completeExample() {

    }


    public List<String> orderAchieve(String product) {

        return shops.stream()
                .map(shop -> String.format("%s price is %.2f", shop.getName(), shop.getPrice(product)))
                .collect(toList());
    }

    @Test
    public void testPerformance() {
        long start = System.nanoTime();
        // System.out.println(orderAchieve("myPhone27S")); 4s
        System.out.println(findPricesParallel("myPhone27S"));  //1s
        long duration = (System.nanoTime() - start) / 1_000_000;
        System.out.println("Done in " + duration + " msecs");
    }


    public List<String> findPricesParallel(String product) {
      /*  return shops.parallelStream()
                .map(shop -> String.format("%s price is %.2f",shop.getName(), shop.getPrice(product)))
                .collect(toList()); */
        //当shop的数量为13的并行执行需要两秒，而12的时候还是1，所以，可以发现可以分配的核数为12.
        return shops1.parallelStream()
                .map(shop -> String.format("%s price is %.2f", shop.getName(), shop.getPrice(product)))
                .collect(toList());
    }


    /*异步执行*/
    public List<String> findPrices(String product) {
        //得到一个CompletableFuture<String>
        List<CompletableFuture<String>> priceFutures =
                shops1.stream()
                        //使用CompletableFuture以异步的方式计算每种商品的价格。
                        .map(shop -> CompletableFuture.supplyAsync(
                                () -> shop.getName() + " price is " +
                                        shop.getPrice(product)))
                        .collect(toList());
        //等待所有的异步操作结束，把CompletableFuture<String>转化为List<String>，通过CompletableFuture的join获得。相当于Future的get
        return priceFutures.stream()
                .map(CompletableFuture::join) //相当于get
                .collect(toList());
    }

    public List<String> findPricesByExecutor(String product) {
        //得到一个CompletableFuture<String>
        List<CompletableFuture<String>> priceFutures =
                shops1.stream()
                        //使用CompletableFuture以异步的方式计算每种商品的价格。
                        .map(shop -> CompletableFuture.supplyAsync(() -> shop.getName() + " price is " +
                                shop.getPrice(product), executor))
                        .collect(toList());
        //等待所有的异步操作结束，把CompletableFuture<String>转化为List<String>，通过CompletableFuture的join获得。相当于Future的get
        return priceFutures.stream()
                .map(CompletableFuture::join) //相当于get
                .collect(toList());
    }

    @Test
    public void testtt() {
        long start = System.nanoTime();
        System.out.println(findPrices("myPhone27S"));  //1s
        long duration = (System.nanoTime() - start) / 1_000_000;
        System.out.println("Done in " + duration + " msecs");
        //获取通用线程池的线程数。
        System.out.println(Runtime.getRuntime().availableProcessors());
    }

    /*由结果可知：无论多少个shop，只要不超过最大线程数，它的执行时间都是1s
    * 这就是异步的好处。这种i/o需要时间多的操作推荐使用异步。*/
    @Test
    public void testExecutor() {
        long start = System.nanoTime();
        System.out.println(findPricesByExecutor("myPhone27S"));  //1s
        long duration = (System.nanoTime() - start) / 1_000_000;
        System.out.println("Done in " + duration + " msecs");
        //获取通用线程池的线程数。
        System.out.println(Runtime.getRuntime().availableProcessors());
    }


}


