package JavaBasicday_06.J195Thread_Runnable;

/**
 * 写一个简单的抢票软件test 共享资源的特性 --票池
 */
public class Ticketting implements Runnable{
    private static int ticket =50;
    @Override
    public void run() {
        while(true){
            //test thread 共享资源的问题
          /*  try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }*/
            if(ticket<=0){
                break;
            }

            //get current thread name
            System.out.println(Thread.currentThread().getName()+""+ticket--);

        }

    }

    public static void main(String[] args) {
        Ticketting ticketting = new Ticketting();

        //创建多个代理角色;Thread 就是一个代理类
        Thread Proxy1 = new Thread(ticketting,"路人甲");
        Thread Proxy2 = new Thread(ticketting,"霸王花");
        Thread Proxy3 = new Thread(ticketting,"成龙");

        Proxy1.start();
        Proxy2.start();
        Proxy3.start();
     }


}
