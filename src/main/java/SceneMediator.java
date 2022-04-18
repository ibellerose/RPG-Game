package main.java;

import java.util.ArrayList;

import javax.swing.JFrame;

public class SceneMediator implements Mediator {
    
    private Player player;
    private Enemy enemy;
    private ArrayList<Wall> adventureWallList;
    
    public SceneMediator(Player player) {
        this.player = player;
        this.adventureWallList = new ArrayList<Wall>();
    }

    @Override
    public void adventure() {
        // TODO Auto-generated method stub

    }

    @Override
    public void store() {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void battle(Player player, Enemy enemy) {
        // TODO Auto-generated method stub
        
    }
    
    public void getAdventureWall(ArrayList<Wall> newWallList) {
        this.adventureWallList = newWallList;
    }


}
