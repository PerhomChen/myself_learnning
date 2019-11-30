package JavaBasicday02;

/**
 * 调用别的类的内部类
 */
public class J52Innerclass {
    public static void main(String[] args){
        //调用如下
       Face a= new Face();
       a.testNose();
       Face.Nose a1 = a.new Nose();
       a1.breath();
       Face.Eye a2 = new Face.Eye();
       a2.listen();
       //两步结合一起创建非静态内部类的实例
        Face.Nose fn = new Face().new Nose();

    }


}

class Face{
    int size;
    static int jjk= 34;
    //外部类不能访问内部类的成员。
    public void testNose(){
       // System.out.println(type);
    }

    class Nose{
        String type;

        void breath(){
            System.out.println(size);
            System.out.println("huxu");
        }
    }

    /**
     * 静态内部类不能直接使用外部类的属性，能使用静态属性
     */
    static class Eye{
        void listen(){
            System.out.println(jjk);


        }
    }

}