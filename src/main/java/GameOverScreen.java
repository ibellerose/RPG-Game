package main.java;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.Timer;


public class GameOverScreen extends JPanel implements ActionListener, MouseListener {
    
    Timer time = new Timer(10,this);
    Player player;
    //Wall w = new Wall(25,25,25,25,0,0);
    ArrayList<Wall> wallList = new ArrayList<Wall>();
    Enemy enemy;
    
    Font font;
    
    SceneMediator sm;
    
    int lastX = 0;
    int lastY = 0;
    
    public GameOverScreen() {
        sm = new SceneMediator();
        this.font = new Font("Verdana", Font.BOLD + Font.ITALIC, 56);
        
        setFocusable(true);
        addMouseListener(this);
        setLayout(new GridBagLayout());
        
        time.start();
    }
    
    public void paint(Graphics g) {
        //g.clearRect(lastX, lastY, 25, 25);
        //g.clearRect(0, 0, getWidth(), getHeight());

        g.setFont(font);
        g.setColor(Color.BLACK);
        g.drawString("Game Over", 20, 250);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mouseClicked(MouseEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mousePressed(MouseEvent e) {
        // TODO Auto-generated method stub
        
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
