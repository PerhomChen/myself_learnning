package JavaBasic03;

public class J54String {
    public static void main(String[] args){
        String a1= "ddf";
        String a2 = "ddf";
     System.out.println(a1==a2);
        System.out.println(a1.equals(a2));
        String a3 = new String("eef");
        String a4 = new String ("eef");
        a3 = "dfdf";
        System.out.println(a3==a4);
        System.out.println(a3.equals(a4));

        System.out.println("################################");
        //indexOf方法应用
        System.out.println(a3.indexOf('f'));
        System.out.println();
        String e = a3.substring(0);
        //replace方法应用

        System.out.println(e.replace('e','*'));
       // split方法应用
        String str = "hello,hi,perform";
        String strArray [] = str.split(",");
        System.out.println(strArray.length);
        for(int i = 0;i< strArray.length;i++){
            System.out.println(strArray[i]);
        }
        //trim:去除首尾空格
        String str1 = "  as df  ds ds ";
        System.out.println(str1.trim());
        //final测试
        String str3 = new String("jk");
        String str4 = new String("djsk");
        str3 = str4;
        System.out.println(str3==str4);

        //equalsIgnoreCase忽略大小写的方法
        System.out.println("era1".equalsIgnoreCase("erA1"));

        //lastIndexOf
        System.out.println("erearej".lastIndexOf('e'));

        //.startsWith是否以下列字符开头
        System.out.println("erqwer".startsWith("er"));

        //endWith是否以下列字符结尾
        System.out.println("erqwer".startsWith("er"));

         //以以下方式创建的字符串会放进常量池里面。
        String strj =  "jk";
        String strh = "uiu";
        strj = strh;
        System.out.println(strj == strh);

        //都变成大写或者小写
        System.out.println("SfdGjk".toLowerCase());
        System.out.println("SfdGjk".toUpperCase());

        //



    }


}
