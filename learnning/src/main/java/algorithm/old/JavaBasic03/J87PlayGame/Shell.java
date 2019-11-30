package JavaBasic03.J87PlayGame;

import java.awt.*;

/**
 * 炮弹类
 */
public class Shell extends GameObject{
    double degree;
    public Shell(){
        x = 200;
        y = 200;
        width = 10;
        height = 10;
        speed = 3;

        degree = Math.random()*Math.PI*2;

    }

    public void draw(Graphics g){
        System.out.println(degree);
        Color c = g.getColor();
        g.setColor(Color.yellow);
        //把颜色还原为原来的颜色。


        g.fillOval((int)x,(int)y,width,height);

        //炮弹朝任意方向飞。
        x += speed*Math.cos(degree);
        y += speed*Math.sin(degree);

        //翻转
        if(x<0||x>Constant.GAME_WIDTH-width)
            degree = Math.PI-degree;
        if(y<30||y>Constant.GAME_HEIGHT-height)
            degree = -degree;

        g.setColor(c);

    }

}
