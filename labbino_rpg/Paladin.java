package labbino_rpg;

public class Paladin extends Swordsman{
    private boolean hasResurrected;
    private int health, damage, shield;
    
    public Paladin(int health, int damage, int shield) {
        super(health, damage, shield);
        this.health = health;
        this.damage = damage;
        this.shield = shield;
        hasResurrected = false;
    }
    public void receiveDamage(int damage) {
        super.receiveDamage(damage);
        if (damage % 2 == 0) {
            damage /= 2;
            damage -= shield;
            health -= damage;
            if (health <= 0) {
                resurrect();
            }
        }
    }
    public void resurrect() {
        if (hasResurrected == false) {
            hasResurrected = true;
            health = 100;
        } else {
            System.out.println("Paladin has died");
        }
    }
}
