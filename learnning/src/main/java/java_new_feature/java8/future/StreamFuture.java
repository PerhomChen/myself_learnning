package java_new_feature.java8.future;

import org.jetbrains.annotations.NotNull;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

/**
 * @Author: Logan Chen
 * @date: 2019/11/6 11:16
 * @Description:
 */
public class StreamFuture {


    List<NewShop> newShops = Arrays.asList(new NewShop("shop"),
            new NewShop("LetsSaveBig"),
            new NewShop("MyFavoriteShop"),
            new NewShop("BuyItAll"),
            new NewShop("BuyIt"));


    List<NewShop> newShops1 = Arrays.asList(new NewShop("BestPrice"),
            new NewShop("LetsSaveBig"),
            new NewShop("MyFavoriteShop"),
            new NewShop("itShop"),
            new NewShop("itShop1"),
            new NewShop("itShop2"),
            new NewShop("itShop3"),
            new NewShop("itShop4"),
            new NewShop("itShop5"),
            new NewShop("itShop6"),
            new NewShop("itShop7"),
            new NewShop("itShop8"),
            new NewShop("BuyItAll"));

    private final Executor executor = Executors.newFixedThreadPool(Math.min(newShops1.size(), 100), new ThreadFactory() {
        @Override
        public Thread newThread(@NotNull Runnable r) {
            Thread t = new Thread(r);
            //使用守护线程。是非守护线程的保姆。
            t.setDaemon(true);
            return t;
        }
    });

    @Test
    public void testNewShop() {
        NewShop newShop = new NewShop("shop");
        System.out.println(newShop.getPrice("iphone xr"));
    }

    @Test
    public void testtt() {
        System.out.println(Discount.Code.values()[4]);
        Random random = new Random();
        System.out.println(random.nextInt(Discount.Code.values().length));
    }

    //顺序执行，花费10s
    @Test
    public void testOrder() {
        long start = System.nanoTime();
        System.out.println(findPrices("iphone xr"));
        long consume = (System.nanoTime() - start) / 1_000_000;
        System.out.println("Done in " + consume + " msecs");
    }

    @Test
    public void testCompleteFuture() {
        long start = System.nanoTime();
        System.out.println(findPricesAsync("iphone x"));
        long consume = (System.nanoTime() - start) / 1_000_000;
        System.out.println("Done in " + consume + " msecs");
    }


    public List<String> findPrices(String product) {
        return newShops.stream()
                .map(shop -> shop.getPrice(product)) //获得每个newshop对象的原始价格
                .map(Quote::parse) //在Quote对象中对shop返回的字符串进行转换
                .map(Discount::applyDiscount) //联系Discount服务，为每个Quote申请折扣
                .collect(toList());
    }

    public List<String> findPricesAsync(String product) {
        List<CompletableFuture<String>> priceFutures =
                newShops1.stream()
                        .map(shop -> CompletableFuture.supplyAsync(() ->
                                shop.getPrice(product), executor))
                        .map(future -> future.thenApply(Quote::parse))
                        .map(future -> future.thenCompose(quote ->
                                CompletableFuture.supplyAsync(() ->
                                        Discount.applyDiscount(quote), executor)))
                        .collect(toList());

        return priceFutures
                .stream()
                .map(CompletableFuture::join)
                .collect(toList());
    }

    public  Stream<CompletableFuture<String>> findPricesStream(String product) {
        return newShops1.stream()
                .map(shop -> CompletableFuture.supplyAsync(() ->
                        shop.getPriceNew(product), executor))
                .map(future -> future.thenApply(Quote::parse))
                .map(future -> future.thenCompose(quote ->
                        CompletableFuture.supplyAsync(() ->
                                Discount.applyDiscount1(quote), executor)));
    }


}

class Discount {
    public enum Code {
        NONE(0),
        SILVER(5),
        GOLD(10),
        PLATINUM(15),
        DIAMOND(20);

        private final int percentage;

        Code(int percentage) {
            this.percentage = percentage;
        }
    }

    //discount服务
    public static String applyDiscount(Quote quote) {
        return quote.getShopName() + "price is " + Discount.apply(quote.getPrice(), quote.getDiscountCode());
    }

    public static String applyDiscount1(Quote quote) {
        return quote.getShopName() + "price is " + Discount.apply1(quote.getPrice(), quote.getDiscountCode());
    }

    //返回打折的价格
    private static double apply(double price, Code code) {
        NewShop.delay();  //模拟Discount的延迟
        return (price * (100 - code.percentage) / 100);
    }

    private static double apply1(double price, Code code) {
        NewShop.randomDeloy();  //模拟Discount的延迟
        return (price * (100 - code.percentage) / 100);
    }
}

class NewShop {

    private String name;

    private static final Random shopRandom = new Random();

    public NewShop(String name) {
        this.name = name;
    }


    public String getPrice(String product) {
        double price = calculatePrice(product);
        Random random = new Random();
        //Discount.Code.values()[1]通过数组下标获取对应的枚举值。
        //random.nextInt(5) : 产生0-4的随机int。
        Discount.Code code = Discount.Code.values()[random.nextInt(Discount.Code.values().length)];
        return String.format("%s:%.2f:%s", name, price, code);
    }

    public String getPriceNew(String product) {
        double price = calculatePriceNew(product);
        Random random = new Random();
        Discount.Code code = Discount.Code.values()[random.nextInt(Discount.Code.values().length)];
        return String.format("%s:%.2f:%s", name, price, code);
    }


    private double calculatePrice(String product) {
        delay(); //休眠一秒
        Random random = new Random();
        return random.nextDouble() * product.charAt(0) + product.charAt(1);
    }

    private double calculatePriceNew(String product) {
        randomDeloy(); //休眠一秒
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


    public static void randomDeloy() {
        int delay = 500 + shopRandom.nextInt(3000);
        try {
            Thread.sleep(delay);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }


}

/*对商店返回的字符串的解析操作封装到了下面的Quote类*/
class Quote {
    private final String shopName;
    private final double price;
    private final Discount.Code discountCode;

    public Quote(String shopName, double price, Discount.Code code) {
        this.shopName = shopName;
        this.price = price;
        this.discountCode = code;
    }

    public static Quote parse(String s) {
        String[] split = s.split(":");
        String shopName = split[0];
        double price = Double.parseDouble(split[1]); //string 通过Double.parseDouble转换为Double。
        Discount.Code discountCode = Discount.Code.valueOf(split[2]);
        return new Quote(shopName, price, discountCode);
    }

    public String getShopName() {
        return shopName;
    }

    public double getPrice() {
        return price;
    }

    public Discount.Code getDiscountCode() {
        return discountCode;
    }
}

class returnAdvance {

    public static void main(String[] args) {
        StreamFuture streamFuture = new StreamFuture();
        long start = System.nanoTime();
        CompletableFuture[] futures = streamFuture.findPricesStream("myPhone27S")
                .map(f -> f.thenAccept(
                        s -> System.out.println(s + " (done in " +
                                ((System.nanoTime() - start) / 1_000_000) + " msecs)")))
                .toArray(size -> new CompletableFuture[size]);
        CompletableFuture.allOf(futures).join();
        System.out.println("All shops have now responded in "
                + ((System.nanoTime() - start) / 1_000_000) + " msecs");
    }


}