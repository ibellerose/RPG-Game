package main.java;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

import java.awt.event.KeyAdapter;

public class BattleScreen extends JPanel implements ActionListener, MouseListener {
    
    Timer t = new Timer(10,this);
    Player player;
    //Wall w = new Wall(25,25,25,25,0,0);
    ArrayList<Wall> wallList = new ArrayList<Wall>();
    Enemy enemy;
    JPanel panel;
    
    Font font = new Font("Serif", Font.PLAIN, 24);
    
    SceneMediator sm = new SceneMediator(player);
    
    int lastX = 0;
    int lastY = 0;
    
    public BattleScreen(Player p, Enemy e, JPanel panel) {
        this.panel = panel;
        this.player = p;
        this.enemy = e;
        
        setFocusable(true);
        addMouseListener(this);
        
        setLayout(new GridBagLayout());
        
        t.start();
    }
    
    public void paint(Graphics g) {
        //g.clearRect(lastX, lastY, 25, 25);
        g.clearRect(0, 0, getWidth(), getHeight());

        //g.setColor(Color.getHSBColor(30, 80, 50));
        g.setColor(new Color(235, 200, 140));
        g.fillRect(0, 0, 590, 395);
        g.setColor(Color.BLACK);
        g.fillRect(0, 395, 590, 5);
       
        //attack 0
        g.setColor(new Color(115, 125, 195));
        g.fillRect(0, 400, 175, 75);
        g.setColor(Color.BLACK);
        g.drawString(player.getAttack(0).getName(), 40, 445);
        
        //attack 1
        g.setColor(new Color(195, 115, 115));
        g.fillRect(175, 400, 175, 75);
        g.setColor(Color.BLACK);
        g.drawString(player.getAttack(1).getName(), 215, 445);
        
        //attack 2
        g.setColor(new Color(195, 145, 115));
        g.fillRect(0, 475, 175, 75);
        g.setColor(Color.BLACK);
        g.drawString(player.getAttack(2).getName(), 40, 515);
        
        //attack 3
        g.setColor(new Color(135, 195, 115));
        g.fillRect(175, 475, 175, 75);
        g.setColor(Color.BLACK);
        g.drawString(player.getAttack(3).getName(), 215, 515);
        
        //enemyName
        g.setColor(Color.BLACK);
        g.drawString(enemy.getName(), 200, 40);
        
        //enemyHealth
        g.setColor(new Color(0, 255, 0));
        if(enemy.getHealth() <= 50) {
            g.setColor(new Color(255, 255, 0));
            if(enemy.getHealth() <= 25) {
                g.setColor(new Color(255, 0, 0));
            }
        }
        g.fillRect(200, 50, enemy.getHealth(), 10);
        //playerHelth
        g.setColor(new Color(0, 255, 0));
        if(player.getHealth() <= 50) {
            g.setColor(new Color(255, 255, 0));
            if(player.getHealth() <= 25) {
                g.setColor(new Color(255, 0, 0));
            }
        }
        g.fillRect(350, 300, player.getHealth(), 10);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        //player.tick();

        repaint();
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mousePressed(MouseEvent e) {
        // TODO Auto-generated method stub
//        if(e.getX() > 0 && e.getY() > 400 && e.getY() < 475 && e.getX() < 75) {
        if(e.getX() > 0 && e.getY() > 400 && e.getX() < 175 && e.getY() < 475) {
            this.enemy.decreaseHealth(this.player.getDamage(0));
        }
        else if(e.getX() > 175 && e.getY() > 400 && e.getX() < 350 && e.getY() < 475) {
            this.enemy.decreaseHealth(this.player.getDamage(1));
        }
        else if(e.getX() > 0 && e.getY() > 475 && e.getX() < 175 && e.getY() < 550) {
            this.enemy.decreaseHealth(this.player.getDamage(2));
        }
        else if(e.getX() > 175 && e.getY() > 475 && e.getX() < 350 && e.getY() < 550) {
            this.enemy.decreaseHealth(this.player.getDamage(3));
        }
        
        if(this.enemy.getHealth() == 0) {
            JFrame frame = (JFrame) SwingUtilities.getAncestorOfClass(JFrame.class,this);
            frame.getContentPane().removeAll();
            this.player.movePlayer(50, 250);
            sm.adventure(frame, this.player);

            frame.revalidate();
            //frame.repaint();
            frame.pack();
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(590, 590);
        }
        else {
            Random rand = new Random();
            
            int randomNumber = rand.nextInt(4);
            this.player.decreaseHealth(this.enemy.getDamage(randomNumber));
            
            if(this.player.getHealth() == 0) {
                JFrame frame = (JFrame) SwingUtilities.getAncestorOfClass(JFrame.class,this);
                frame.getContentPane().removeAll();
    
                //frame.getContentPane().add(sm.getScreen());
                sm.gameOver(frame);
    
                frame.revalidate();
                //frame.repaint();
                frame.pack();
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setSize(590, 590);
            }
        }
        
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
