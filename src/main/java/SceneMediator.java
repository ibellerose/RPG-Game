package main.java;

import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class SceneMediator implements Mediator {
    
//    private Player player;
//    private ArrayList<Wall> adventureWallList;
    private JPanel panel;
    
    public SceneMediator() {
        //this.adventureWallList = new ArrayList<Wall>();
    }
    
    public SceneMediator(Player player) {
        //this.player = player;
        //this.adventureWallList = new ArrayList<Wall>();
    }

    @Override
    public void adventure(JFrame frame) {
        // TODO Auto-generated method stub
        AdventureScreen s = new AdventureScreen();
        
        s.setFocusable(true);
        
        frame.add(s);
        frame.setVisible(true);
    }
    
    @Override
    public void adventure(JFrame frame, Player player) {
        // TODO Auto-generated method stub
        AdventureScreen s = new AdventureScreen(player);
        
        s.setFocusable(true);
        
        frame.add(s);
        frame.setVisible(true);
    }

    @Override
    public void store() {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void battle(JFrame frame, Player p, Enemy e) {
        // TODO Auto-generated method stub
        BattleScreen s = new BattleScreen(p, e, this.panel);
        
        s.setFocusable(true);
        
        frame.add(s);
        frame.setVisible(true);
    }
    
    @Override
    public void battle(JFrame frame, Player p, Enemy e, JPanel panel) {
        // TODO Auto-generated method stub
        this.panel = panel;
        BattleScreen s = new BattleScreen(p, e, panel);
        
        s.setFocusable(true);
        
        frame.add(s);
        frame.setVisible(true);
    }
    
//    public void getAdventureWall(ArrayList<Wall> newWallList) {
//        this.adventureWallList = newWallList;
//    }

//    public AdventureScreen getScreen() {
//        return this.screen;
//    }
//    
//    public JFrame getFrame() {
//        return this.frame;
//    }

    @Override
    public void gameOver(JFrame frame) {
        // TODO Auto-generated method stub
        
        GameOverScreen s = new GameOverScreen();
        
        s.setFocusable(true);
        
        frame.add(s);
        frame.setVisible(true);
    }

}
