package JavaBasicday_06.J195Thread_Runnable;

public class TestProgrammer {
    public static void main(String[] args) {
        Programmer programmer = new Programmer();
        //创建代理角色
        Thread proxy = new Thread(programmer);
        //run
        proxy.start();

        proxy.notify();
        for(int i=0;i<100;i++){
            System.out.println("赛弗斯u run复赛发动step");
        }
    }
}
