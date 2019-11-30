package JavaBasicday_06;

import java.util.concurrent.*;

public class J196Callable {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //get 执行调度服务--ExecutorService
        ExecutorService ser = Executors.newFixedThreadPool(2);
        //创建目标类
        Race tortoise = new Race("砍块",1000);
        Race rabbit = new Race("小兔子",500);
        //获取值
        Future<Integer> result1 = ser.submit(tortoise);
        Future<Integer> result2 = ser.submit(rabbit);

        Thread.sleep(2000);//2s

        tortoise.setFlag(false);
        rabbit.setFlag(false);
        int num1 = result1.get();
        int num2 = result2.get();
        System.out.println("乌龟跑了"+num1+"步");
        System.out.println("小兔子跑了"+num2+"步");

        ser.shutdownNow();
    }


}

class Race implements Callable<Integer> {
    private String name;
    private long time;
    private boolean flag = true;
    private int step = 0;
    public Race(){

    }
    public Race(String name,long time){
        this.name = name;
        this.time = time;
    }
    @Override
    public Integer call() throws Exception {
        while(flag){
            //用sleep来决定他们速度
            Thread.sleep(time);
            step++;
        }
        return step;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public int getStep() {
        return step;
    }

    public void setStep(int step) {
        this.step = step;
    }
}