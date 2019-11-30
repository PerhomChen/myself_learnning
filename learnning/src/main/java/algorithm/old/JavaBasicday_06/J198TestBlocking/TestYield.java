package JavaBasicday_06.J198TestBlocking;

/**
 * test yield
 *
 */
public class TestYield extends Thread {

    public static void main(String[] args) throws InterruptedException {
        TestYield testYield = new TestYield();
        testYield.start();

        for(int i=0;i<100;i++){
            if(i%20==0){
                testYield.yield();
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
