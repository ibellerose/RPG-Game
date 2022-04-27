package main.java;

import javax.swing.JButton;
import javax.swing.JFrame;

public class App extends JFrame {
    JFrame appFrame;
    JButton wall = new JButton("Wall");
    JButton enemy = new JButton("enemy");
    SceneMediator sm = new SceneMediator();

    //JFrame frame
    public App() {
        //appFrame = frame;
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(590, 590);
        setLocationRelativeTo(null);
        setTitle("RPG Game");
        setResizable(false);
        
        sm.adventure(this);
        
        //init();
    }
    
    //initiate 
//    public void init() {
//        
//        AdventureScreen s = new AdventureScreen();
//        
//        add(s);
//        setVisible(true);
//    }
//    
//    public SceneMediator getMediator() {
//        return this.sm;
//    }
}