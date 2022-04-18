package main.java;

import java.awt.GridLayout;
import java.awt.Label;

import javax.swing.JFrame;

public class App extends JFrame{

    public App(JFrame frame) {        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 400);
        setLocationRelativeTo(null);
        setTitle("RPG Game");
        
        Init();
    }
    
    public void Init() {
        setLayout(new GridLayout(1,1,0,0));
        
        Screen s = new Screen();
        
        add(s);
        
        setVisible(true);
        
    }
}
