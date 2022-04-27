package main.java;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Enemy extends Rectangle {
    private int dx;
    private int dy;
    private Attack[] attacks = new Attack[4];
    private int health;
    private String name;
    
    public Enemy(int dx, int dy, String newName) {
        //setBounds(x,y,width,height);
        setBounds(25, 25, 25, 25);
        this.dx = dx;
        this.dy = dy;
        this.name = newName;
        attacks[0] = new Attack("Sword Attack", 10);
        attacks[1] = new Attack("Sheild Bash", 5);
        attacks[2] = new Attack("Magic Attack", 12);
        attacks[3] = new Attack("Sword Throw", 25);
        health = 100;
    }
    
    public void tick() {
        this.x = dx - (dx % 25);
        this.y = dy - (dy % 25);
    }
    
    public void draw(Graphics g) {
        g.setColor(Color.GREEN);
        g.fillRect(this.x, this.y, this.width, this.height);
    }
    
    public void setDx(int dx) {
        this.dx = dx;
    }
    
    public void setDy(int dy) {
        this.dy = dy;
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
    
    public String getName() {
        return this.name;
    }
    
    public void changeAttack(int index, String newName, int newDamage) {
        int realIndex = index % 4;
        attacks[realIndex] = new Attack(newName, newDamage);
        
    }
}
