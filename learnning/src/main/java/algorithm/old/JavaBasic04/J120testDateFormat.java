package JavaBasic04;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class J120testDateFormat {
    public static void main(String[] args) {
        //时间格式类，字母必须按照规定的来，
        //因为所有的字母都被定义了含义
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss,属于本年的第w周");
        Date d = new Date(1232342333234L);
        /**
         * 把时间对象按照df的格式转换为字符串。
         */
        String str = df.format(d);
        System.out.println(str);

        /**
         * 把字符串转换为时间对象
         */

        String str2 = "1988-04-23";
        DateFormat df2 = new SimpleDateFormat("yyyy-MM-dd");

        try {
            //把df2格式的字符串转换为时间对象
            Date d2 = df2.parse(str2);
            System.out.println(d2);
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }
}
