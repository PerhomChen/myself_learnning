package JavaBasic03.J87PlayGame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class TestPhoto extends JFrame {
   Image beak = GameUtil.getImage("images/beak.jpg");
    public void launchFrame(){

        this.setTitle("学员--Perform");
        this.setSize(800,500);
        this.setVisible(true);
        this.setLocation(200,150);

        //匿名内部类,彻底关闭按钮
        this.addWindowListener(new WindowAdapter(){
            public void windowClosing(WindowEvent e){
                System.exit(0);
            }

        });
    }

    public void paint(Graphics g){
        g.drawImage(beak,0,0,null);

    }

    public static void main(String[] args) {
        TestPhoto tp = new TestPhoto();
        tp.launchFrame();

    }


}
