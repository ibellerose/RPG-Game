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

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

import java.awt.event.KeyAdapter;

public class AdventureScreen extends JPanel implements ActionListener, KeyListener, MouseListener {
    
    Timer t = new Timer(10,this);
    Player p = new Player(25,25,25,25,100,100);
    //Wall w = new Wall(25,25,25,25,0,0);
    ArrayList<Wall> wallList = new ArrayList<Wall>();
    ArrayList<Enemy> enemyList = new ArrayList<Enemy>();
    boolean willIntercect = false;
    boolean isWall = true;
    boolean battle = false;
    
    Font font = new Font("Serif", Font.PLAIN, 24);
    
    SceneMediator sm = new SceneMediator(p);
    EnemyFactory enemyFactory = new EnemyFactory();
    
    int lastX = 0;
    int lastY = 0;
    
    public AdventureScreen() {
        addKeyListener(this);
        setFocusable(true);
        addMouseListener(this);
        
        setLayout(new GridBagLayout());
        Enemy firstEnemy = enemyFactory.getEnemy();
        enemyList.add(firstEnemy);
        
        t.start();
    }
    
    public AdventureScreen(Player player1) {
      this.p = player1;
      addKeyListener(this);
      setFocusable(true);
      addMouseListener(this);
      
      setLayout(new GridBagLayout());
      Enemy firstEnemy = enemyFactory.getEnemy();
      enemyList.add(firstEnemy);
      
      t.start();
  }
    
    public void paint(Graphics g) {
        //g.clearRect(lastX, lastY, 25, 25);
        g.clearRect(0, 0, getWidth(), getHeight());

        if(isWall) {
            g.setColor(Color.getHSBColor(200, 20, 50));
            g.fillRect(0, 0, 100, 50);
        }else {
            g.setColor(Color.GREEN);
            g.fillRect(0, 0, 100, 50);
        }
        
        p.draw(g);
        for(int i = 0; i < wallList.size(); i++) {
            wallList.get(i).draw(g);
        }
        for(int i = 0; i < enemyList.size(); i++) {
            enemyList.get(i).draw(g);
        }
        
        g.setColor(Color.BLACK);
        g.setFont(font);
        g.drawString("Enemy", 15, 30);
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
                if(wallList.get(i).intersects(p.getX() + 25, p.getY(), 25, 25))
                    willIntercect = true;
            }
            if(!willIntercect)
                p.setDx(25);
            break;
        case KeyEvent.VK_DOWN:
        case KeyEvent.VK_S:
            for(int i = 0; i < wallList.size(); i++) {
                if(wallList.get(i).intersects(p.getX(), p.getY() + 25, 25, 25))
                    willIntercect = true;
            }
            if(!willIntercect)
                p.setDy(25);
            break;
        case KeyEvent.VK_LEFT:
        case KeyEvent.VK_A:
            for(int i = 0; i < wallList.size(); i++) {
                if(wallList.get(i).intersects(p.getX() - 25, p.getY(), 25, 25))
                    willIntercect = true;
            }
            if(!willIntercect)
                p.setDx(-25);
            break;
        case KeyEvent.VK_UP:
        case KeyEvent.VK_W:
            for(int i = 0; i < wallList.size(); i++) {
                if(wallList.get(i).intersects(p.getX(), p.getY() - 25, 25, 25))
                    willIntercect = true;
            }
            if(!willIntercect)
                p.setDy(-25);
            break;
        }
           
        for(int i = 0; i < enemyList.size(); i++) {
            if(p.intersects(enemyList.get(i))) {
                battle = true;
                System.out.println("Battle");
                
                //change scene
                JFrame frame = (JFrame) SwingUtilities.getAncestorOfClass(JFrame.class,this);
                JPanel panel = this;
                frame.getContentPane().removeAll();

                //sm.battle(frame, p, enemyList.get(i));
                sm.battle(frame, p, enemyList.get(i), panel);

                frame.revalidate();

                frame.pack();
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setSize(590, 590);
            }
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
        for(int i = 0; i < enemyList.size(); i++) {
            enemyList.get(i).tick();
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

        if(isWall && (!(e.getX() < 100) || !(e.getY() < 50))) {
            Wall w = new Wall(25,25,25,25,e.getX(),e.getY());
            wallList.add(w);
        }
        if(!isWall && (!(e.getX() < 100) || !(e.getY() < 50))) {
            //Enemy enemy = new Enemy(e.getX(),e.getY());
            Enemy enemy = enemyFactory.getEnemy();
            enemyList.add(enemy);
        }
        
        if(e.getX() < 100 && e.getY() < 50) {
            isWall = false;
        }
        else {
            isWall = true;
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
