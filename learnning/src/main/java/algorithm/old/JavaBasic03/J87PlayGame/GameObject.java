package JavaBasic03.J87PlayGame;

import java.awt.*;

public class GameObject {
     Image img;
    double x,y;
     int speed;
     int width,height;

    //画笔画自己
    public void drawSelf(Graphics g){
        g.drawImage(img,(int)x,(int)y,null);


    }

    //多个构造方法
    public GameObject(Image img, double x, double y,int speed) {
        this.img = img;
        this.x = x;
        this.y = y;
        this.speed = speed;
    }

    public GameObject(Image img, double x, double y, int width, int height) {
        this.img = img;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public GameObject() {
    }

    /**
     *   返回物体所在的矩形所有的位置和大小
     *   便于以后的碰撞检测
     * @return
     */
    public Rectangle getRect(){

        return new Rectangle((int)x,(int)y,width,height);
    }

    //getter,setter 方法
    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {

        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public double getY() {

        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getX() {

        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public Image getImg() {

        return img;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public void setImg(Image img) {
        this.img = img;
    }
}

