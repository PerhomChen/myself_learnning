package JavaBasicday_06.J202SingleModel;

/**
 * 单例模式2--恶汉式（使用前创建）
 *   method1：直接写(类加载时就创建该对象)
 *   method2：用静态内部类把创建实例并返回给静态变量的代码包裹起来
 *
 */
//method 1
public class MyJVM2 {

    private static MyJVM2 instance = new MyJVM2();

    private MyJVM2(){

    }

    public static MyJVM2 getInstance(){
        return  instance;
    }
}
/**
 * mothod 2
 *    ---静态内部类包裹
 *         --延缓加载时间，避免提早占用内存，提高内存利用率
 */

class MyJvm3{
    private static class getInstance{
        private MyJvm3 instance = new MyJvm3();
    }
   private MyJvm3(){

    }
    //调用这个方法时，才创建实例。
    public static MyJvm3 getinstance(){
        return getinstance();
    }
}