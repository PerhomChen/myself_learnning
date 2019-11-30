package JavaBasicday_06;
//test thread 终止
public class J197TestStudy_thread {
    public static void main(String[] args) {
        Study study = new Study();
        new Thread(study).start();
        for(int i=0;i<100;i++){
            if(50==i){
                study.setFlag(false);
            }
            System.out.println("main---");
        }
    }
}

class Study implements Runnable{
    //线程类中定义 线程体使用的标识
    private boolean flag = true;
    @Override
    public void run() {
        while(flag){
            System.out.println("sjkdsdhfjksd111");
        }
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }
}
