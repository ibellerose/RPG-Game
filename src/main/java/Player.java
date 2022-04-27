package main.java;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Player extends Rectangle {
    private int dx;
    private int dy;
    private Attack[] attacks = new Attack[4];
    private int health;
    
    public Player(int x, int y, int width, int height, int dx, int dy) {
        setBounds(x,y,width,height);
        this.dx = dx;
        this.dy = dy;
        attacks[0] = new Attack("Sword Attack", 10);
        attacks[1] = new Attack("Sheild Bash", 5);
        attacks[2] = new Attack("Magic Attack", 12);
        attacks[3] = new Attack("Sword Throw", 25);
        health = 100;
    }
    
    public void tick() {
        this.x = dx;
        this.y = dy;
    }
    
    public void draw(Graphics g) {
        g.setColor(Color.BLACK);
        g.fillRect(this.x, this.y, this.width, this.height);
    }
    
    public void setDx(int dx) {
        this.dx += dx;
    }
    
    public void setDy(int dy) {
        this.dy += dy;
    }
    
    public int getDx() {
        return this.dx;
    }
    
    public int getDy() {
        return this.dy;
    }
    
    public int getDamage(int index) {
        return attacks[index].getDamage();
    }
    
    public int getHealth() {
        return this.health;
    }
    
    public void decreaseHealth(int healthChange) {
        int newHealth = this.health;
        newHealth -= healthChange;
        if (newHealth < 0) {
            this.health = 0;
        } else {
            this.health = newHealth;
        }
    }
    
    public Attack getAttack(int index) {
        return attacks[index];
    }
    
    public void movePlayer(int x, int y) {
        this.dx = x;
        this.dy = y;
    }

}
