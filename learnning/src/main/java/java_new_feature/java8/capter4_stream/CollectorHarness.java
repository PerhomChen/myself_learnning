package java_new_feature.java8.capter4_stream;

/**
 * @Author: Logan Chen
 * @date: 2019/10/29 17:21
 * @Description:
 */
public class CollectorHarness {
    public static void main(String[] args) {
        Collect collect = new Collect();

        long fastest = Long.MAX_VALUE;
        for (int i = 0; i < 10; i++) {
            //返回正在运行的Java虚拟机的高分辨率时间源的当前值，以纳秒为单位。
            //此方法只能用于测量经过的时间
            long start = System.nanoTime();
            collect.partitionPrimesWithCustomCollector(1_000_000);
            long duration = (System.nanoTime() - start) / 1_000_000;
            if (duration < fastest) fastest = duration;
        }
        System.out.println("Fastest execution done in " + fastest + " msecs");

        fastest = Long.MAX_VALUE;

        for (int i = 0; i < 10; i++) {
            long start = System.nanoTime();
            collect.partitionPrimes(1_000_000);
            long duration = (System.nanoTime() - start) / 1_000_000;
            if (duration < fastest) fastest = duration;
        }
        System.out.println("ord Fastest execution done in " + fastest + " msecs");
    }
}
