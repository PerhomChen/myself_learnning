package JavaBaisc;

public class Java13TestOperator {
    public static void main(String[] arg){
        double a = 14.2%3;  //结果=2.1999999999999993
        System.out.println(a);
        boolean a1 = 1>2&&2>(3/0);//测试逻辑运算短路的问题。
        System.out.println(a1);
        int c= 12>>3;
        System.out.println(c);

        //字符串连接符
        String atr = "ads";
        int a4 = 3;
        System.out.println(atr+a4);

        //三目运算符
        int b = 5;
        a = 3;
        atr = (a<b)?"a<b":"a>b";

        System.out.println(atr);

    }

}
