package JavaBasicday_06;

/**
 * 把ticketing 改为线程安全的
 */

public class J201_synchronized implements Runnable{
    private static int ticket =10;
    private boolean flag = true;
    @Override
    public void run() {
        while(flag){
            test1();
            }


        }

    public  void test1(){
        synchronized (this){
            if(ticket<=0){
                flag = false;
                return;
            }
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+""+ticket--);
        }

    }

    public static void main(String[] args) {
        J201_synchronized ticketting = new J201_synchronized();
        Thread Proxy1 = new Thread(ticketting, "路人甲");
        Thread Proxy2 = new Thread(ticketting, "霸王花");
        Thread Proxy3 = new Thread(ticketting, "成龙");

        Proxy1.start();
        Proxy2.start();
        Proxy3.start();

    }


        }