package main.java;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class App extends JFrame{
    JFrame appFrame;
    JButton wall = new JButton("Wall");
    JButton enemy = new JButton("enemy");

    public App(JFrame frame) {
        appFrame = frame;
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 400);
        setLocationRelativeTo(null);
        setTitle("RPG Game");
        
        Init();
    }
    
    public void Init() {
        setLayout(new GridLayout(2,0));
        
        Screen s = new Screen();
        
        add(s);
        
        setVisible(true);
    }
}
