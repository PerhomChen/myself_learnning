package JavaBasicday_06.J198TestBlocking;

public class J198TestJoin extends Thread{
    public static void main(String[] args) throws InterruptedException {
        J198TestJoin j198TestJoin = new J198TestJoin();
        j198TestJoin.start();

        for(int i=0;i<100;i++){
            if(i==50){
                j198TestJoin.join();
            }
            System.out.println("main run "+i+"setp");
        }
    }

    @Override
    public void run() {
        for(int i=0;i<1000;i++){
            System.out.println("run "+i+"step!!");
        }
    }
}

