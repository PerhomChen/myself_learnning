package JavaBaisc;

import java.util.Scanner;

/**
 *
 */
public class Java27TestScanner {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
      //  String str = s.next();//等待的是字符串
        System.out.println("请输入加数");

       int a = s.nextInt();
        System.out.println("请输入被加数");
        int a2 = s.nextInt();
        System.out.println("和="+(a+a2));
    }
}
