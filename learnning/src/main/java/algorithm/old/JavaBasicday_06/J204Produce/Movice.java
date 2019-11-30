package JavaBasicday_06.J204Produce;

/**
 * 使用生产者消费者模式解决多个线程争夺同一份资源的问题，
 *   -解决死锁而出现的（信号灯法）
 */
public class Movice {

    private String pic;
    //信号灯
    //flag = true;生产者生产，消费者等待，生产完后通知消费
    //flag = false ；生产者等待，消费者消费。消费完后通知生产
    private  boolean flag = true;

    public synchronized void play(String pic){
        //flag,生产者等待
        if(!flag){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        //开始生产
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //生产完毕
        this.pic = pic;
        System.out.println("生产了"+pic);
        //通知消费
        this.notify();
        //生产者停下
        this.flag = !flag;
    }
    public synchronized void watch(){
        //flag=true watcher wait
        if(flag){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        //开始消费
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("消费了"+pic);
        //消费完毕，通知生产
        this.notifyAll();
        //消费停止
        this.flag = !flag;
    }
}
