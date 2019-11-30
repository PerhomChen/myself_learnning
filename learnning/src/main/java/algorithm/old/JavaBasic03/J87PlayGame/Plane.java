package JavaBasic03.J87PlayGame;

import java.awt.*;
import java.awt.event.KeyEvent;

public class Plane extends GameObject{
    //上下左右
    boolean up,down,left,right;

    boolean live = true;


    //重写父类的重画方法
    @Override
    public void drawSelf(Graphics g) {
        if(live) {
       g.drawImage(img,(int)x,(int)y,null);


           if (left)
               x -= speed;
           if (right)
               x += speed;
           if (up)
               y -= speed;
           if (down)
               y += speed;
       }

    }

    //构造方法
    public Plane(Image img,double x,double y,int speed){
        this.img = img;
        this.x = x;
        this.y = y;
        this.speed =speed;
        this.height = img.getHeight(null);
        this.width = img.getWidth(null);
    }

    /**
     * 键盘控制飞机的方法
     */
    //监听按下键并作出改变
    public void addDiretion(KeyEvent e){
        System.out.println(speed);
        switch(e.getKeyCode()){
            case KeyEvent.VK_LEFT:
                left = true;

                break;
            case KeyEvent.VK_UP:
                up = true;
                break;
            case KeyEvent.VK_RIGHT:
                right = true;
                break;
            case KeyEvent.VK_DOWN:
                down = true;
                break;

        }
    }

    //监听抬起键并作出改变
    public void minusDiretion(KeyEvent e){
        switch(e.getKeyCode()){
            case KeyEvent.VK_LEFT:
                left = false;
                break;
            case KeyEvent.VK_UP:
                up = false;
                break;
            case KeyEvent.VK_RIGHT:
                right = false;
                break;
            case KeyEvent.VK_DOWN:
                down = false;
                break;

        }
    }


}
