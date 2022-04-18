package main.java;

import javax.swing.JFrame;

public interface Mediator {
    public void adventure();
    public void store();
    public void battle(Player player, Enemy enemy);
    
}