package JavaBaisc;

public class Java36TestStatic {
    int a;
    String name;
    static  int id ;
    public static void printid(){
        System.out.println(id);
    }

    public static void main(String[] args){

    }
}
class Test {
    public static void main(String[] args) {
        Java36TestStatic.id=8989;
        Java36TestStatic.printid();
        Java36TestStatic a1 = new Java36TestStatic();
        System.out.println(a1.id);
    }
}

