package JavaBasic03.J87PlayGame;


import javax.swing.JFrame;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Date;


public class PlayGame03 extends Frame {

    //导入图片
    Image planeImg = GameUtil.getImage("images/plane.jpg");
    Image bg = GameUtil.getImage("images/blackground.png");

    //飞机坐标
    Plane plane  = new Plane(planeImg,250,250,4);
    Shell shell[] = new Shell[50];
    Explode ex ;

    //时间
    Date startTime = new Date();
    Date endTime ;

    //记录飞机死亡时间
    int period ;

    /**
     * 初始化窗口
     */
    public void launchFrame(){

        this.setTitle("学员--Perform");
        this.setSize(Constant.GAME_WIDTH,Constant.GAME_HEIGHT);
        this.setVisible(true);
        this.setLocation(200,150);

        //匿名内部类,彻底关闭按钮
        this.addWindowListener(new WindowAdapter(){
            public void windowClosing(WindowEvent e){
                System.exit(0);
            }

        });

        //启动线程

        new PaintThread().start();

        //启动键盘监听
        addKeyListener(new keyMonitor());

        //数组的初始化
        for (int i =0;i<shell.length;i++)
        {
            shell[i] = new Shell();
        }

    }

    /**
     * 内部类：键盘监听器。
     */
    class keyMonitor extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {
            System.out.println("按下"+e.getKeyCode());
            plane.addDiretion(e);
        }

        @Override
        public void keyReleased(KeyEvent e) {
         //   System.out.println("抬起"+e.getKeyCode());
            plane.minusDiretion(e);
        }
    }
    /**
     * 内部类,这个线程帮助我们反复地重画
     */
    class PaintThread extends Thread{
        public void run(){
            while(true){
              //  System.out.println("窗口重画！");

                repaint();//重画
                try {
                    Thread.sleep(40);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }

        }


    }
    public void paint(Graphics g){
        //保存原来的颜色
        Color c = g.getColor();
        g.drawImage(bg,0,0,null);
        plane.drawSelf(g);

        //画50个炮弹
        for(int i=0;i<shell.length;i++){
            shell[i].draw(g);

            boolean peng = shell[i].getRect().intersects(plane.getRect());


                if (peng) {
                    plane.live = false;

                    if (ex == null) {
                        ex = new Explode(plane.x, plane.y);
                        //计算存活时间放在这里
                        endTime = new Date();
                        period = (int) ((endTime.getTime() - startTime.getTime()) / 1000);

                    }
                    ex.draw(g);

                }

                    if (!plane.live) {

                        g.setColor(Color.RED);
                        Font f = new Font("微软雅黑", Font.BOLD, 40);
                        g.setFont(f);
                        g.drawString("存活：" + period + "秒", (int) plane.x, (int) plane.y);


                    }
                    g.setColor(c);



            }





    }




    public static void main(String[] args) {
       PlayGame03 pg = new PlayGame03();
        pg.launchFrame();

    }

    /**
     * 双缓冲技术
     */

    private Image offScreenImage = null;

    public void update(Graphics g){
        if(offScreenImage == null)
        {
            offScreenImage = this.createImage(Constant.GAME_WIDTH,Constant.GAME_HEIGHT);

        }
        Graphics gOff = offScreenImage.getGraphics();
        paint(gOff);
        g.drawImage(offScreenImage,0,0,null);
    }
}
