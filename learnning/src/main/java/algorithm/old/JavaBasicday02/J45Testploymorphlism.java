package JavaBasicday02;

public class J45Testploymorphlism {
    //在构造器中测试this关键字实际指向最终的对象
    public J45Testploymorphlism(){
        this.voice();
    }
    public void voice(){

        System.out.println("普通动物的叫声");
    }

}

class Cat extends J45Testploymorphlism{

    public void voice(){
        System.out.println("mmmmm");
    }
    public void carry(){
        System.out.println("I will carry you!");
    }
}

class pig extends J45Testploymorphlism{
    public void voice(){
        System.out.println("zzzz");
    }
}
