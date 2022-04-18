package main.java;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;
import javax.swing.Timer;

public class Screen extends JPanel implements ActionListener, KeyListener {

    Timer t = new Timer(10,this);
    Player p = new Player(25,25,25,25,1,1);
    
    public Screen() {
        addKeyListener(this);
        setFocusable(true);
        
        t.start();
    }
    
    public void paint(Graphics g) {
        g.clearRect(0, 0, getWidth(), getHeight());
        
        p.draw(g);
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
        
        repaint();
        
    }

}
