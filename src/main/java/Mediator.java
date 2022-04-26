package main.java;

import javax.swing.JFrame;

public interface Mediator {
    public void adventure(JFrame frame);
    public void store();
    public void battle(JFrame frame, Player p, Enemy e);
    public void gameOver(JFrame frame);    
}