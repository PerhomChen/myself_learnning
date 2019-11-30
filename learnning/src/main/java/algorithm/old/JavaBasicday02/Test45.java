package JavaBasicday02;

/**
 * 测试多态
 */
public class Test45 {
    public static void testAnimalVoice(J45Testploymorphlism a){
        a.voice();
        if (a instanceof Cat){
            ((Cat)a).carry();
        }

    }
    public static void main(String [] args){
        //多态---父类的引用指向一个子类的对象
       J45Testploymorphlism a = new Cat();
         testAnimalVoice(a);

         Cat b = new Cat();
        ( (J45Testploymorphlism)b).voice();
       ((Cat) a).carry();
    }
}
