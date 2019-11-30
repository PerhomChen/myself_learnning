package JavaBasic04;

public class J117TestInteger {
    public static void main(String[] args) {
        //把一个数字用包装类存储起来
        Integer i = new Integer(23);
        //把一个字符串的数字用包装类存储起来
        Integer i1 = new Integer("3432");
        System.out.println(Integer.MAX_VALUE);
        //把字符串数字转换为数字
        Integer j = Integer.parseInt("243");
        System.out.println(j);
        //返回int类型的值

        System.out.println(j.intValue()+43);



    }
}
