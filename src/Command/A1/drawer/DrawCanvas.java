package drawer;

import command.*;

import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class DrawCanvas extends Canvas implements Drawable {
    // 颜色              
    private Color color;    
    // 要绘制的圆点的半径     
    private int radius;     
    // 命令的历史记录
    private MacroCommand history;
    // 构造函数
    public DrawCanvas(int width, int height, MacroCommand history) {
        setSize(width, height);
        setBackground(Color.white);
        this.history = history;
        init();                             
    }
    // 重新全部绘制
    public void paint(Graphics g) {
        history.execute();
    }
    // 初始化                               
    public void init() {                    
        color = Color.red;                  
        radius = 6;                         
        history.append(new ColorCommand(this, color));
    }                                       
    // 绘制
    public void draw(int x, int y) {
        Graphics g = getGraphics();
        g.setColor(color);
        g.fillOval(x - radius, y - radius, radius * 2, radius * 2);
    }
    public void setColor(Color color) {     
        this.color = color;                 
    }                                       
}
