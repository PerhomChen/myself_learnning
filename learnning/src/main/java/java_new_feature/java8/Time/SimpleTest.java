package java_new_feature.java8.Time;


import org.junit.Test;

import java.time.*;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.util.Date;

/**
 * @Author: Logan Chen
 * @date: 2019/11/6 15:35
 * @Description:
 */
public class SimpleTest {
    @Test
    public void oldTime() {
        Date data = new Date(114, 2, 18); //与1900年的相差值：2014.03.18
        System.out.println(data);
    }

    @Test
    public void localDateTest() {
        //只表示日期
        LocalDate date = LocalDate.of(2014, 3, 18);
        int year = date.getYear();  //获取年份
        Month month = date.getMonth(); //获取月份，包装在Month中
        int day = date.getDayOfMonth(); //获取天数
        DayOfWeek dow = date.getDayOfWeek(); //获取星期几
        int len = date.lengthOfMonth(); //获取这个月的长度
        boolean leap = date.isLeapYear(); //是否为闰年
        LocalDate today = LocalDate.now(); //以工厂方法获取当前的日期
        System.out.println(LocalDate.now());

        //使用TemporalField读取LocalDate的值
        int year1 = date.get(ChronoField.YEAR);
        int month1 = date.get(ChronoField.MONTH_OF_YEAR);
        int day1 = date.get(ChronoField.DAY_OF_MONTH);
    }

    @Test
    public void localTimeTest() {
        //只表示时间
        LocalTime time = LocalTime.of(13, 45, 20);
        int hour = time.getHour();
        int minute = time.getMinute();
        int second = time.getSecond();

        //使用字符串创建
        LocalDate localDate = LocalDate.parse("2014-03-18");
        LocalTime localTime = LocalTime.parse("13:45；20");

    }

    @Test
    public void LocalDateTimeTest(){
        //同时表示日期和时间
        LocalDateTime dateTime = LocalDateTime.of(2014,Month.MARCH,18,13,45,20);

        //使用LocalTime和LocalDate合成LocalDateTime
        LocalDate date = LocalDate.of(2014, 3, 18);
        LocalTime time = LocalTime.of(13, 45, 20);
        LocalDateTime dt1 = LocalDateTime.of(date,time);
        LocalDateTime dt2 = date.atTime(time);
        LocalDateTime dt4 = time.atDate(date);
        LocalDateTime dt3 = date.atTime(13, 45, 20);

        //从LocalDateTime提取LocalDate和LocalTime
        LocalDate date1 = dateTime.toLocalDate();
        LocalTime time1 = dateTime.toLocalTime();
    }

    /**
      *@Description: 上面示范的都是人类便于理解的日期和时间，下面的方法示范的是机器理解的日期和时间
      *@Author:  Logan Chen
      *@Time:  2019/11/6 16:14
      *@Change:
      */
    @Test
    public void InstantTest(){
        //同样是以1970-01-01 00:00:00为基准的
        System.out.println(Instant.ofEpochSecond(3));
        //第二个参数是纳秒
        System.out.println(Instant.ofEpochSecond(3,1_000_000_000));
    }

    /**
      *@Description: Duration主要以秒和纳秒衡量时间的长短
      *@Author:  Logan Chen
      *@Time:  2019/11/6 16:26
      *@Change:
      */
    @Test
    public void DurationTest(){
        //duration in localTime
        LocalTime localTime = LocalTime.of(13,45,20);
        LocalTime localTime1 = LocalTime.of(23,12,9);
        Duration d1 = Duration.between(localTime,localTime1);
        System.out.println(d1.getSeconds());
        //duration in LocalDateTime
        LocalDateTime dateTime = LocalDateTime.of(2014,Month.MARCH,18,13,45,20);
        LocalDateTime dateTime1 = LocalDateTime.of(2015,Month.MARCH,12,23,15,8);
        Duration d2 = Duration.between(dateTime,dateTime1);
        System.out.println(d2.getSeconds());
        //duration in Instant
        Duration d3 = Duration.between(Instant.ofEpochSecond(2),Instant.now());
        System.out.println(d3.getSeconds());

        //以年、月、日的方式获得时间间隔
        Period tenDays = Period.between(LocalDate.of(2014,3,18),LocalDate.of(2018,9,30));
        //只能单一获得年、月、日
        System.out.println(tenDays.getDays());

        //创建间隔时间
        Duration threeMinutes = Duration.ofMinutes(3);
        Duration threeMinutes1 = Duration.of(3, ChronoUnit.MINUTES);
        Period tenDays1 = Period.ofDays(10);
        Period threeWeeks = Period.ofWeeks(3);
        Period twoYearsSixMonthsOneDay = Period.of(2, 6, 1);
    }

}
