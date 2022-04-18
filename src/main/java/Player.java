package main.java;

import java.awt.Graphics;
import java.awt.Rectangle;

public class Player extends Rectangle {
    private int dx, dy;
    
    public Player(int x, int y, int width, int height, int dx, int dy) {
        setBounds(x,y,width,height);
        this.dx = dx;
        this.dy = dy;
    }
    
    public void tick() {
        this.x = dx;
        this.y = dy;
    }
    
    public void draw(Graphics g) {
        g.fillRect(this.x, this.y, this.width, this.height);
    }
    
    public void setDx(int dx) {
        this.dx += dx;
    }
    
    public void setDy(int dy) {
        this.dy += dy;
    }

}
