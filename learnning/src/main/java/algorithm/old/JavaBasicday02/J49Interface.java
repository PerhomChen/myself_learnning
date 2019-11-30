package JavaBasicday02;

public interface J49Interface {
    //接口里面只有常量和抽象方法
    //接口中定义常量时默认前面是public static final
     String MAX_SARARY = "2334";
    int MAX_VALUE = 78;
    //写不写修饰符都是 public abstract
    void run();
    public int jj(int a ,int b);

}

interface Attack{
    public void attack();
}