package main.java;

import javax.swing.JFrame;
import javax.swing.JPanel;

public interface Mediator {
    public void adventure(JFrame frame);
    public void adventure(JFrame frame, Player player);
    public void store();
    public void battle(JFrame frame, Player p, Enemy e);
    public void battle(JFrame frame, Player p, Enemy e, JPanel j);
    public void gameOver(JFrame frame);    
}