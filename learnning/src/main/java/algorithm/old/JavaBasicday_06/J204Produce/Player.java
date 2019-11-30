package JavaBasicday_06.J204Produce;

public class Player implements Runnable{
    private  Movice movice;

    public Player(Movice movice) {
        this.movice = movice;
    }

    @Override
    public void run() {
        for(int i=0;i<20;i++){

           if(i%2==0){
               movice.play("左边");
           }else{
               movice.play("右边");
           }

        }
    }
}
