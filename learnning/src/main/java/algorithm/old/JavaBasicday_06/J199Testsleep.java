package JavaBasicday_06;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 利用sleep实现倒计时
 */
public class J199Testsleep {
    public static void main(String[] args) throws InterruptedException {
        Date endTime = new Date(System.currentTimeMillis()+10*1000);
        long end = endTime.getTime();
        while(true){
            System.out.println(new SimpleDateFormat("mm:ss").format(endTime));
            //休眠1s
            Thread.sleep(1000);
            endTime = new Date(endTime.getTime()-1000);
            if(end-10000>endTime.getTime()){
                break;
            }
        }
    }


}
