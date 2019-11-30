package JavaBasicday02;

/**
 * 包含了抽象方法的类必须是抽象类
 */
public abstract class J48TestAbstractClass {
    //抽象方法
    public abstract void run();
    public void breath(){
        System.out.println("呼吸！");
        //实际使用时，调用的肯定是一个子类对象，所有调用的是子类所重写的方法。
        run();
    }
    public J48TestAbstractClass(){
        System.out.println("动物！");
    }



}

//子类必须实现抽象方法--类似于必须实现规范
 class CatCat extends J48TestAbstractClass{
    public void run(){

        System.out.println("jjj");
    }
    public static void main(String [] args){
        CatCat a1 = new CatCat();
        a1.run();
    }



}
