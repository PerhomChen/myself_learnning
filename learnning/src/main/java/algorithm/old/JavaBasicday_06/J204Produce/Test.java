package JavaBasicday_06.J204Produce;

public class Test {
    public static void main(String[] args) {
        Movice movice = new Movice();
        Player player = new Player(movice);
        Watcher watcher = new Watcher(movice);

        Thread p = new Thread(player);
        Thread w = new Thread(watcher);

        p.start();
        w.start();
    }

}
