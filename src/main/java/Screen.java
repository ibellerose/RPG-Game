package main.java;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import javax.swing.JPanel;
import javax.swing.Timer;

public class Screen extends JPanel implements ActionListener, KeyListener, MouseListener {

    Timer t = new Timer(10,this);
    Player p = new Player(25,25,25,25,50,50);
    //Wall w = new Wall(25,25,25,25,0,0);
    ArrayList<Wall> wallList = new ArrayList<Wall>();
    boolean willIntercect = false;
    
    int lastX = 0;
    int lastY = 0;
    
    public Screen() {
        addKeyListener(this);
        setFocusable(true);
        addMouseListener(this);
        
        t.start();
    }
    
    public void paint(Graphics g) {
        g.clearRect(lastX, lastY, 25, 25);
        //g.clearRect(0, 0, 25, 25);
        
        p.draw(g);
        g.setColor(Color.GRAY);
        for(int i = 0; i < wallList.size(); i++) {
            wallList.get(i).draw(g);
        }
    }
    
    @Override
    public void keyTyped(KeyEvent e) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void keyPressed(KeyEvent e) {
        // TODO Auto-generated method stub
        lastX = p.getDx();
        lastY = p.getDy();
        
        willIntercect = false;
        
        switch(e.getKeyCode()) {
        case KeyEvent.VK_RIGHT:
        case KeyEvent.VK_D:
            for(int i = 0; i < wallList.size(); i++) {
                //if((wallList.get(i).getDx() + 25) == p.getDx() && (wallList.get(i).getDy()) == p.getDy())
                if(wallList.get(i).intersects(p.getX() + 25, p.getY(), 25, 25))
                    willIntercect = true;
            }
            if(!willIntercect)
                p.setDx(25);
            break;
        case KeyEvent.VK_DOWN:
        case KeyEvent.VK_S:
            for(int i = 0; i < wallList.size(); i++) {
                //if((wallList.get(i).getDy() + 25) == p.getDy() && (wallList.get(i).getDx()) == p.getDx())
                if(wallList.get(i).intersects(p.getX(), p.getY() + 25, 25, 25))
                    willIntercect = true;
            }
            if(!willIntercect)
                p.setDy(25);
            break;
        case KeyEvent.VK_LEFT:
        case KeyEvent.VK_A:
            for(int i = 0; i < wallList.size(); i++) {
                //if((wallList.get(i).getDx() - 25) == p.getDx() && (wallList.get(i).getDy()) == p.getDy())
                if(wallList.get(i).intersects(p.getX() - 25, p.getY(), 25, 25))
                    willIntercect = true;
            }
            if(!willIntercect)
                p.setDx(-25);
            break;
        case KeyEvent.VK_UP:
        case KeyEvent.VK_W:
            for(int i = 0; i < wallList.size(); i++) {
                //if((wallList.get(i).getDy() - 25) == p.getDy() && (wallList.get(i).getDx()) == p.getDx())
                if(wallList.get(i).intersects(p.getX(), p.getY() - 25, 25, 25))
                    willIntercect = true;
            }
            if(!willIntercect)
                p.setDy(-25);
            break;
        }
        
    }

    @Override
    public void keyReleased(KeyEvent e) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        p.tick();
        for(int i = 0; i < wallList.size(); i++) {
            wallList.get(i).tick();
        }
        repaint();
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mousePressed(MouseEvent e) {
        // TODO Auto-generated method stub
        Wall w = new Wall(25,25,25,25,e.getX(),e.getY());
        wallList.add(w);
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        // TODO Auto-generated method stub

        
    }

    @Override
    public void mouseExited(MouseEvent e) {
        // TODO Auto-generated method stub
        
    }

}
