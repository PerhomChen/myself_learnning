package java_new_feature.java8.Time;

import org.junit.Test;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.*;
import java.util.Locale;

import static java.time.temporal.TemporalAdjusters.*;

/**
 * @Author: Logan Chen
 * @date: 2019/11/6 16:45
 * @Description:
 */
public class ChangeTime {


    @Test
    public void simpleTest() {
        //直观操作时间类
        LocalDate date1 = LocalDate.of(2014, 3, 18);
        LocalDate date2 = date1.withYear(2011);
        LocalDate date3 = date2.withDayOfMonth(25);
        LocalDate date4 = date3.with(ChronoField.MONTH_OF_YEAR, 9);

        //相对的方式修改
        LocalDate date5 = LocalDate.of(2014, 3, 18);
        //支持链式操作
        LocalDate date6 = date1.plusWeeks(1).minusYears(3);
        LocalDate date8 = date3.plus(6, ChronoUnit.MONTHS);
    }

    @Test
    public void complexOperatorTest() {
        LocalDate date1 = LocalDate.of(2014, 3, 18);
        //创建一个新的日期，并将其值设定为日期调整后第一个符合执行星期几要求的日期。如果已经符合要求，直接返回对象。
        LocalDate date2 = date1.with(nextOrSame(DayOfWeek.SUNDAY));
        LocalDate date3 = date2.with(lastDayOfMonth());
    }

    @Test
    public void TemporalAdjusterTest(){
        LocalDate date = LocalDate.of(2014, 3, 18);
        date = date.with(new NextWorkingDay());
        System.out.println(date);
        date.with(nextWorkingDay);
    }

    //封装在TemporalAdjuster中
    TemporalAdjuster nextWorkingDay = TemporalAdjusters.ofDateAdjuster(
            temporal -> {
                DayOfWeek dow =
                        DayOfWeek.of(temporal.get(ChronoField.DAY_OF_WEEK));
                int dayToAdd = 1;
                if (dow == DayOfWeek.FRIDAY) dayToAdd = 3;
                if (dow == DayOfWeek.SATURDAY) dayToAdd = 2;
                return temporal.plus(dayToAdd, ChronoUnit.DAYS);
            });


    /**
      *@Description: 和DateFormat比较，所有的DateTimeFormatter实例都是线程安全的
      *@Author:  Logan Chen
      *@Time:  2019/11/6 18:02
      *@Change:
      */
    @Test
    public void formatTest(){
        /*使用预定义的DateTimeFormatter实例*/
        LocalDate date = LocalDate.of(2014,03,18);
        //20140318
        String s1 = date.format(DateTimeFormatter.BASIC_ISO_DATE);
        System.out.println(s1);
        //2014-03-18
        System.out.println(date.format(DateTimeFormatter.ISO_LOCAL_DATE));

        //把字符串重新创建伟日期对象
        LocalDate date1 = LocalDate.parse("20140318",DateTimeFormatter.BASIC_ISO_DATE);

        //创建自定义模式的DateTimeFormatter
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String formattedDate = date.format(formatter);
        System.out.println(formattedDate);
        LocalDate date2 = LocalDate.parse(formattedDate,formatter);

        /*创建一个本地化的DateTimeFormatter*/
        DateTimeFormatter italianFormatter =
                DateTimeFormatter.ofPattern("d. MMMM yyyy", Locale.ITALIAN);
        LocalDate date4= LocalDate.of(2014, 3, 18);
        String formattedDate1 = date.format(italianFormatter); // 18. marzo 2014
        LocalDate date3 = LocalDate.parse(formattedDate, italianFormatter);
    }


    //DateTimeFormatterBuilder一步步创建DateTimeFormatter
    @Test
    public void DateTimeFormatterBuilderTest(){
        DateTimeFormatter italianFormatter = new DateTimeFormatterBuilder()
                .appendText(ChronoField.DAY_OF_MONTH)
                .appendLiteral(". ")
                .appendText(ChronoField.MONTH_OF_YEAR)
                .appendLiteral(" ")
                .appendText(ChronoField.YEAR)
                .parseCaseInsensitive()
                .toFormatter(Locale.ITALIAN);
    }

    @Test
    public void ZoneIdTest(){
        ZoneId romeZone =ZoneId.of("Europe/Rome"); //格式：区域/城市

        //为时间点添加时区信息
        LocalDate date = LocalDate.of(2014, Month.MARCH,18);
        ZonedDateTime zdt1 = date.atStartOfDay(romeZone);
        System.out.println(zdt1);

        LocalDateTime dateTime = LocalDateTime.of(2014,Month.MARCH,18,13,45);
        ZonedDateTime zdt2 = dateTime.atZone(romeZone);
        System.out.println(zdt2);

        //把现在的当地时间转换为目标时区
        Instant instant = Instant.now();
        ZonedDateTime zdt3 = instant.atZone(romeZone);
        System.out.println(zdt3);

        //ZoneOffset;自定义时区时间
        ZoneOffset offset = ZoneOffset.of("-05:00");
        LocalDateTime dateTime1 = LocalDateTime.of(2014, Month.MARCH, 18, 13, 45);
        OffsetDateTime dateTimeInNewYork = OffsetDateTime.of(dateTime1, offset);
        System.out.println(dateTimeInNewYork);
    }


}

/**
 * @Description: 自定义的日期时间操作类计算明天工作日的日期
 * @Author: Logan Chen
 * @Time: 2019/11/6 17:33
 */
class NextWorkingDay implements TemporalAdjuster {
    @Override
    public Temporal adjustInto(Temporal temporal) {
        //get的时候使用ChronoField
        DayOfWeek dow = DayOfWeek.of(temporal.get(ChronoField.DAY_OF_WEEK));
        int dayToAdd = 1;
        if (dow == DayOfWeek.FRIDAY) dayToAdd = 3;
        else if (dow == DayOfWeek.SATURDAY) dayToAdd = 2;
        //操作日期的时候使用ChronoUnit
        return temporal.plus(dayToAdd, ChronoUnit.DAYS);
    }
}