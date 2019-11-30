package JavaBasicday_06.schedule;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class Timer01 {
    public static void main(String[] args) {
        Timer timer = new Timer();
        //安排指定时间内完成的任务
        //1s后开始执行，每隔200毫秒运行一次
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("sdds");
            }
        },new Date(System.currentTimeMillis()+1000),200);
    }
}
