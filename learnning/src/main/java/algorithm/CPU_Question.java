package algorithm;

import static java.lang.Thread.sleep;

/**
 * @Author: Logan Chen
 * @date: 2019/10/25 16:01
 * @Description:
 */
public class CPU_Question {

    //CPU的占用率：CPU忙的时间和刷新周期总时间的比率。
    //所以，我们可以写一个程序，让它在任务管理器的刷新周期内一会儿忙，一会儿闲，然后通过调节忙/闲的比例，就可以控制任务管理器中CPU的占用率了。

    public static void main(String[] args) {
        for (; ; ) {
            for (int i = 0; i < 9600000; i++) ;
            try {
                sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }




}
