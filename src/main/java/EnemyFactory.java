package main.java;

import java.util.Random;

public class EnemyFactory {
    
    public Enemy getEnemy() {
        
        Random rand = new Random();
        
        int randomNumber = rand.nextInt(4);
        
        if (randomNumber == 0) {
            Enemy e = new Enemy(400,100,"Goblin");
            e.changeAttack(2, "Headbutt", 3);
            e.changeAttack(3, "Goblin Rush", 20);
            return e;
        } else if (randomNumber == 1) {
            Enemy e = new Enemy(400,100,"Giant");
            e.changeAttack(0, "Club Smash", 15);
            e.changeAttack(1, "Rock Throw", 25);
            e.changeAttack(2, "Body Slam", 35);
            e.changeAttack(3, "Miss", 0);
            return e;
        } else if (randomNumber == 2) {
            Enemy e = new Enemy(400,100,"Skeleton");
            e.changeAttack(2, "Arrow Attack", 5);
            return e;
        } else {
            Enemy e = new Enemy(400,100,"Wizard");
            e.changeAttack(0, "Lightning Bolt", 45);
            e.changeAttack(1, "Miss", 0);
            e.changeAttack(3, "Miss", 0);
            return e;
        }
    }

}
