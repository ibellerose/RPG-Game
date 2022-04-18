package main.java;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;
import javax.swing.Timer;

public class Screen extends JPanel implements ActionListener, KeyListener, MouseListener {

    Timer t = new Timer(10,this);
    Player p = new Player(25,25,25,25,0,0);
    Wall w = new Wall(25,25,25,25,0,0);
    
    public Screen() {
        addKeyListener(this);
        setFocusable(true);
        addMouseListener(this);
        
        t.start();
    }
    
    public void paint(Graphics g) {
        g.clearRect(0, 0, getWidth(), getHeight());
        
        p.draw(g);
        w.draw(g);
    }
    
    @Override
    public void keyTyped(KeyEvent e) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void keyPressed(KeyEvent e) {
        // TODO Auto-generated method stub
        switch(e.getKeyCode()) {
        case KeyEvent.VK_RIGHT:
        case KeyEvent.VK_D:
            p.setDx(25);
            break;
        case KeyEvent.VK_DOWN:
        case KeyEvent.VK_S:
            p.setDy(25);
            break;
        case KeyEvent.VK_LEFT:
        case KeyEvent.VK_A:
            p.setDx(-25);
            break;
        case KeyEvent.VK_UP:
        case KeyEvent.VK_W:
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
        w.tick();
        repaint();
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mousePressed(MouseEvent e) {
        // TODO Auto-generated method stub
        
        w.setDx(e.getX());
        w.setDy(e.getY());
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
