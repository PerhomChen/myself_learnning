package QinghuaDSA.Introduction;

public class test {
    int a =1;


}

 class test1 extends test{
    int b ;
    int a =2;

    public int getB(){
         return b = super.a;
    }
     public static void main(String[] args) {

         test1 t1 = new test1();

         System.out.println(t1.a+"");
         System.out.println(t1.getB()+"");

     }
}