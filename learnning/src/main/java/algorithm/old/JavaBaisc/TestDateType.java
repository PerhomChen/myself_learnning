package JavaBaisc;


public class TestDateType {
    public static void main (String[] arg){
        int money = 1000000000;
        int year = 20;
        int total = money*year;
        System.out.println(total);//超过int范围，结果得到为负数=-1474836480。因为高位自动丢失并且有
        // 的高位覆盖了符号位。
        long times = 54L*343*34*237799*43;//L尽量放在前面，不然乘到后面之前已经溢出了。
        System.out.println(times);
    }
}
