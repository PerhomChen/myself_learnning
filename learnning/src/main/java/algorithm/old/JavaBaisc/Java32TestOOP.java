package JavaBaisc;

public class Java32TestOOP {


        public static void main(String [] args) {
            //通过类加载器Class.Loader加载该类。加载后，在方法区中就有了该类的信息。
            Java30TestOOP a = new Java30TestOOP();
            a.name = "陈培鸿";
            a.sayGoodbye("陈巧静");
            a.study();
            Java30TestOOP a1 = new Java30TestOOP();
            a1.name = "kjk";
            a1.age = 21;
            //通过构造器初始化对象的属性
            Java32TestOOP01 a2 = new Java32TestOOP01("Apple");
            System.out.println(a2.brand);
            a2.cpuSpeed=121323;
            a1.computer = a2;
            System.out.println(a1.computer.brand);
        }

}
