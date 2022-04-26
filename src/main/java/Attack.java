package main.java;

public class Attack {
    private String name;
    private int damage;
    
    public Attack(String newName, int newDamage) {
        this.name = newName;
        this.damage = newDamage;
    }
    
    public void setDamage(int newDamage) {
        this.damage = newDamage;
    }
    
    public void setName(String newName) {
        this.name = newName;
    }
    
    public int getDamage() {
        return this.damage;
    }
    
    public String getName() {
        return this.name;
    }

}
