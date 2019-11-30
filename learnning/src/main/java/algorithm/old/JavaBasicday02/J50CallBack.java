package JavaBasicday02;

public class J50CallBack {

}
//希望每个子类都实现的话，使用抽象类或者接口
 abstract class  MyFrame{
    public abstract void paint();



}

class MyFrame1 extends MyFrame{
    public void paint(){
        System.out.println("把自画出;';d;fld来");
    }}

/**
 * Java中的awt类的画窗口就是类似这样的原理，挂一个钩子等程序员回调自己编写写好的代码
 */
class PaintFrame{
    public static void drawFrame(MyFrame s){
        System.out.println("启动线程");
        System.out.println("增加循环");
        System.out.println("查看消息栈");

        //画窗口.
        //因为每次画的窗口都不一样，所以传MyFrame的子类，每次调用的时候都传不同的子类。
        s.paint();

        System.out.println("启动缓存，增加效率");
    }
    public static void main(String[] args){

        drawFrame(new MyFrame1());
    }


}
