package JavaBasicday02;

public class J49InterfaceImplement implements J49Interface ,Attack{
     int a = 23;
    public void run(){

    }
    public int jj(int b, int a){
        System.out.println("jjkjkj");
        return a+b;
    }
    public void attack(){

    }
    public static void main(String[] args){
        J49Interface a1 = new J49InterfaceImplement();

    }

}
