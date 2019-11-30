package JavaBasicday_06.J193Thread;

public class Tortoise extends Thread {

    @Override
    public void run(){
        for(int i=0;i<100;i++){
            System.out.println("Tortoise run" +i+"step.");
        }

    }
}