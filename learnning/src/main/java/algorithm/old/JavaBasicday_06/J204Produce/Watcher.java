package JavaBasicday_06.J204Produce;

public class Watcher implements Runnable {
    private Movice movice;

    public Watcher(Movice movice) {
        this.movice = movice;
    }

    @Override
    public void run() {
        for(int i=0;i<20;i++){
            movice.watch();
        }
    }
}
