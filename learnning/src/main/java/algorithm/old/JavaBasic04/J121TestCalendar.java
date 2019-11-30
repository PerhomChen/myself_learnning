package JavaBasic04;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class J121TestCalendar {
    //Calendar是抽象类
    public static void main(String[] args) {
        Calendar  c = new GregorianCalendar();
        c.set(2001,Calendar.FEBRUARY,22,12,23,12);
        System.out.println(c.getTime());

        //一个一个set;如果没设置时分秒，则返回当前时刻的时分秒。
        c.set(Calendar.YEAR,2005);
        c.set(Calendar.MONTH,5);
        c.set(Calendar.DATE,5);
        System.out.println(c.get(Calendar.YEAR));

        //直接传一个时间对象
        //c.setTime(new Date());

        /**
         * 日期计算
         */
        c.add(Calendar.YEAR,30);
        System.out.println(c.getTime());

    }
}
