package JavaBasicday02;

import com.sun.net.httpserver.HttpServer;

public class J47HttpServlet {
    public void servlet(){
        System.out.println("HttpServlet.servlet()");
        //前面默认隐藏了this
        doGet();
    }
    public void doGet(){
        System.out.println("HttpServlet.doGet()");

    }


}

class MyServlet extends J47HttpServlet{
    public void doGet(){
        System.out.println("jkkk");
    }

}

/**
 * 测试servlet中应用的多态--父类引用指向子类对象
 */
class Test01 {
    public static void main(String [] args){
        J47HttpServlet a = new MyServlet();
        a.servlet();

    }
}