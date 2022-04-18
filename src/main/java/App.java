package main.java;

import javax.swing.JFrame;

public class App extends JFrame{

    public App() {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1000, 800);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setTitle("RPG Game");
    }
}
