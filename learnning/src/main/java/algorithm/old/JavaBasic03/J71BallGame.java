package JavaBasic03;

import java.awt.*;
import javax.swing.*;


public class J71BallGame extends JFrame{
    Image ball = Toolkit.getDefaultToolkit().getImage("images/ball.png");
    Image desk = Toolkit.getDefaultToolkit().getImage("images/beak.jpg");

    double x = 100;
    double y =100;
  boolean right = true;

    double degree = Math.PI/3;
    //画窗口的方法
       public void paint(Graphics g){
           System.out.println("窗口被画了一次");
           g.drawImage(desk,0,0,null);
           g.drawImage(ball,(int)x,(int)y,null);


               x = x+10*Math.cos(degree);
               y = y+10*Math.sin(degree);


           if(y>430||y<70){
               degree = -degree;
           }
           //碰到左右边界

           if(x>856-40-30||x<70) {
               degree = Math.PI-degree;

           }



    }
    void launchFrame(){
        setSize(856,500);
        setLocation(250,80);
        setVisible(true);

        //无限重画
        while(true){
            repaint();

            //每秒画25次
            try{
                Thread.sleep(40);
            }catch(Exception e){
                e.printStackTrace();
            }
        }
    }
    public static void main(String[] args) {
        J71BallGame bg = new J71BallGame();
        bg.launchFrame();


    }


}
