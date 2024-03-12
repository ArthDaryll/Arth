package labbino_rpg;

public class Character {
    private int health, damage, shield;
    
    public Character(int health, int damage, int shield) {
        this.health = health;
        this.damage = damage;
        this.shield = shield;
    }
     int getHealth() {
        return health;
    }
     int getDamage() {
        return damage;
    }
     int getShield() {
        return shield;
    }
    void setHealth() {
        this.health = health;
    }
    public void receiveDamage(int damage) {
        health -= (damage - shield);
                if (health <= 0) {
                    System.out.println("Character has died");
                }
    }
}
