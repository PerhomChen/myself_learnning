package JavaBasic03.J87PlayGame;

import javax.swing.JFrame;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * 飞机游戏的主窗口
 */
public class MyGameFrame extends JFrame {

    Image ball = GameUtil.getImage("images/ball.png");

    /**
     * 初始化窗口
     */
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

    /**
     * 自动被调用，相当于一只画笔。
     * @param g
     */
    public void paint(Graphics g){
        /**
         * 解决调用paint函数全黑的原因：
         *    setVisible会调用一次panit方法，而setSize会改变窗口大小，然后再次自动调用paint方法，
         *    清空所写的内容，所以会出现黑屏，
         *   解决方法：
         *   1.setSize方法写在setVisible前面，
         *   2.在paint方法里面添加paint方法。
         *   */
        //super.paint(g);
        /**
         * 先把原来的颜色进行保存。
         * 字体保存
         */
        Color c = g.getColor();
        Font f = g.getFont();

        g.setColor(Color.BLUE);
        g.setFont(new Font("微软雅黑",Font.BOLD,40));

        System.out.println("窗口被画了一次");
        //画一条直线
        g.drawLine(100,100,300,300);
        //画一个矩形
        g.drawRect(100,100,300,300);
        //画一个椭圆--依靠外切矩形来画
        g.drawOval(100,100,300,300);
        //填充一个矩形
        g.fillRect(100,100,40,40);
        //画字符串
        g.drawImage(ball,250,250,null);
        g.setColor(Color.RED);
        g.drawString("你是汗",200,200);




    }


    public static void main(String[] args) {
        MyGameFrame mg = new MyGameFrame();
        mg.launchFrame();

    }
}
