package JavaBasicday_06.J193Thread;

import JavaBasicday_06.J193Thread.Rabbit;
import JavaBasicday_06.J193Thread.Tortoise;

public class Test {
    public static void main(String[] args) {
        Rabbit rabbit = new Rabbit();
        Tortoise tortoise = new Tortoise();
        //调用start方法，不要调用run方法，run方法自己调用。
        rabbit.start();
        tortoise.start();

        for(int i=0;i<100;i++){
            System.out.println("main run "+i+"step!");
        }

    }
}
