package JavaBasic04;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class J122VisualCalendar {
    public static void main(String[] args) {
        //获取键盘输入流
        System.out.println("请按照以下格式输入：2019-2-22");
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();

        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        //把字符串转成时间对象
        try {
            Date d = df.parse(str);
            Calendar cd = new GregorianCalendar();
            cd.setTime(d);
            //解决当月从星期几开始
            int day = cd.get(Calendar.DATE);
            cd.set(Calendar.DATE,1);
            int fristDay = cd.get(Calendar.DAY_OF_WEEK);
            //得到当月的最大天数
            int maxDays = cd.getActualMaximum(Calendar.DATE);
            System.out.println("日\t一\t二\t三\t四\t五\t六");
            for(int j=1;j<fristDay;j++){
                System.out.print("\t");
            }
            for (int i=1;i<=maxDays;i++){
                if(i==day)
                    System.out.print("*");
                System.out.print(i+"\t");
                if(cd.get(Calendar.DAY_OF_WEEK)==Calendar.SATURDAY)
                    System.out.println();
                cd.add(Calendar.DATE,1);
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }


    }
}
