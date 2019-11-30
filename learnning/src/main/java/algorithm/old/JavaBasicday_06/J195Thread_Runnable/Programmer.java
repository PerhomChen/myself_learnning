package JavaBasicday_06.J195Thread_Runnable;

/**
 * use runnable interface create thread
 * step1：implement runnable interface ,override run method  -->真实角色类
 * step2:启动多线程，采用静态代理
 *      --创建真实角色类
 *      --创建代理类+真实角色的引用
 *      --调用.start();
 */
public class Programmer implements Runnable{
    @Override
    public void run() {
        for(int i=0;i<100;i++){
            System.out.println("you run many step");
        }
    }
}
