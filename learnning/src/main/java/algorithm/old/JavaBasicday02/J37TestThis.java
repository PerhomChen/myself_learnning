package JavaBasicday02;

public class J37TestThis {
    String name;
    int id;
    public void study(){
        this.name = "kdsj";
        System.out.println(name);
    }
    public J37TestThis (String name){
        this(); //通过this（）调用另一个构造器。
               //Call to 'this()' must be first statement in constructor body
        this.name = name;
        System.out.println(this.name);
    }
    public J37TestThis(){
        System.out.println("342");
    }
    public static void main(String[] args){
        J37TestThis a1 = new J37TestThis("静静");
        a1.study();

    }

}
