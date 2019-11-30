package JavaBaisc;

/**
 *
 */
public class Java24TestMethod {
    public static void main(String[] args){

        test01();
    }
    public static void test01(){
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

class Java24TestRecursion{
    public static void main(String[] args){
        long total=0;
       for(int a1=1;a1<20;a1++){
           long io=factorial(a1);
           total +=io;
        System.out.println(io);}
    }

    /**
     *
     * @param i（所要计算的阶乘）
     * @return 阶乘的取值
     */
    //用递归算阶乘
    static long factorial(int i){
        if(i==1)
            return 1;
        else
            return i*factorial(i-1);
    }

}