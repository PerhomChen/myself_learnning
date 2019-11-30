package JavaBaisc;

public class Java17TestIf {
    public static void main (String[] args){
       double b = 1+Math.random()*4;
       System.out.println(b);
        if (b>3)
            System.out.println("dashu");
        else

            System.out.println("sd");

    }
}
class Java18TestSwitch{
    public static void main(String[] args){
        int a = 1 + (int)(Math.random()*6);
     //Switch语句
        switch(a){  //括号
            case 6:
                System.out.println(a+"点");
                break; //没有break的话，就会发生case穿透的现象
            case 5:
                System.out.println(a+"点");
                break;
                case 4:
                System.out.println(a+"点");
                    break;
                case 3:
                System.out.println(a+"点");
                    break;
                case 2:
                System.out.println(a+"点");
                    break;
            default:
                System.out.println(a+"点");
                break;
        }

        System.out.println(a);
    }

}
//测试JDK7.0switch新特性--增加了括号类的类型可以为字符串。
class Java19TestSwitch02{
    public static void main(String[] args){
       String a = "静静菁菁";
       switch (a){
           case "静静菁菁":
               System.out.println("静静菁菁dek");
               break;
           case"ds":
               System.out.println("静k");
               break;
       }

    }
}


class Java19Testwhile{
    public static void main(String[] args){
        int a = 1;  //初始化
       while(a<101){//括号里面布尔表达式--条件判断
           System.out.print(a+"  "); //循环体
           a++;  //迭代

        }
        int sum =0;
       a = 1;
        System.out.println();
       while(a<101){
           sum +=a;
           a++;
       }
       System.out.println(sum);
    }
}

class Java19Test{
    public static void main(String[] args){
        //1~1000被5整出的数
        int a =0;
        for (int a1 = 1;a1<1001;a1++){ //初始化，判斷條件，迭代
            if (a1%5==0)
            System.out.print(a1+"  "); //循環體
            if (a1%15==0)
                System.out.println();
                }

                //1~100的奇偶数的和
        int sum =0;
        int sum1 =0;
        a = 1;
        System.out.println();
        while(a<101){
           if(a%2==0) sum +=a;
            else sum1 +=a;
            a++;
        }
        System.out.println(sum);
        System.out.println(sum1);

        //1~100分别求和再相加
        a=1;
        int sum3 = 0;
        for(int a1=1;a1<101;a1++){
            int b =0;
            for(int a2=1;a2<a1;a2++){
                b += a2;
            }
            sum3 += b;
        }
        System.out.println(sum3);

        //1~10的阶乘相加的和
        int sum4 =0;
        for(int r =1;r<=10;r++){
            int b =1;

            for(int a2=1;a2<=r;a2++){
                b *= a2;

            }
            sum4 += b;

        }
        System.out.println(sum4);

        //da打印输出99乘法表
        for (int a1= 1;a1<=9;a1++){
            for(int a2 = 1;a2 <= a1;a2++){
                System.out.print(a1+"*"+a2+"="+a1*a2+"\t");
            }
            System.out.println();
        }
    }
}

class Java23Testbreak{
    public static void main(String[] args){

        //测试break
       int total =0;


       while(true){
           total++;
           int i = (int)(Math.random()*100);
           if(i==55) {

               break;
           }
       }
        System.out.println(total);

       //测试continue--打印1~100能被3整除的数
        for(int a1 =1;a1<=100;a1++){
            if(a1%3!=0){
                continue;
            }
                System.out.println(a1);
        }

        //带标签的continue--输出1~100的质数
        int count =0;
        outer: for(int a1=1;a1<=100;a1++){
            for(int a2=2;a2<a1/2;a2++){
                if(a1%a2==0)
                    continue outer;
            }
            System.out.print(a1+"  ");
            count++;

        }
        System.out.println();
        System.out.println(count);
    }
}