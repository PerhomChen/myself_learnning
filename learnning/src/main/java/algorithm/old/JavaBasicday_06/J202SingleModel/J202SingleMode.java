package JavaBasicday_06.J202SingleModel;

/**
 * 实现单例模式
 */
public class J202SingleMode {

    public static void main(String[] args) {
      ThreadJvm jvm1 = new ThreadJvm(500);
      ThreadJvm jvm2 = new ThreadJvm(200);
      jvm1.start();
      jvm2.start();
        System.out.println(jvm1==jvm2);

    }
}

/**
 * 懒汉式：(懒得创建对象，在你使用的时候才创建对象)
 * double check。
 * 1.构造器私有化：避免外部直接创建对象
 * 2.声明一个私有静态变量--表示这个类的实例对象
 * 3、创建一个对外的公共的静态的访问该变量，如果该变量为null，就创建，否则就return该实例对象。
 *
 * 问题：
 *     多线程的环境下，可能两个线程都进入到了 if(instance==null){
 *             instance =  new Jvm();
 *         }
 *         就会创建两个实例。
 */
class Jvm{
    private static Jvm instance =null;

    private Jvm(){

    }
    //设置不同延时时间，增大出错概率
    //结果Thread-1JavaBasicday_06.Jvm@394c4fe4
    //Thread-0JavaBasicday_06.Jvm@2fa637b8
    //创建了两个实例
    public static Jvm getInstance2(long time) throws InterruptedException {
        if(instance==null){
            Thread.sleep(time);
            instance =  new Jvm();
        }
        return instance;

    }

    /**
     * 采用同步锁，可以解决多线程带来的问题
     * --问题：无论是对象有没有创建，都需要进行等待，
     * @param time
     * @return
     * @throws InterruptedException
     */
    public synchronized static Jvm getInstance1(long time) throws InterruptedException {
        if(instance==null){
            Thread.sleep(time);
            instance =  new Jvm();
        }
        return instance;

    }
    public static Jvm getInstance(long time) throws InterruptedException {
        //如果对象已存在，就不需要获得锁。
        //提高了已经存在对象的访问效率
        if(instance == null) {

       //锁类的字节码，，class loader？a,b
            synchronized (Jvm.class) {
                if (instance == null) {
                    instance = new Jvm();
                    Thread.sleep(time);
                }
            }
        }

        return instance;

    }
}

/**
 *  模拟多线程环境
 */
class ThreadJvm extends Thread{
    private long time ;
    public ThreadJvm(long time){
        this.time = time;
    }
    @Override
    public void run() {
        try {
            System.out.println(Thread.currentThread().getName()+"" +
                    ""+Jvm.getInstance(time));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}