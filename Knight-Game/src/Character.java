public abstract class Character {

    private int health;
    private int damage;

    public int getDamage() {
        return damage;
    }

    public int getHealth() {
        return health;
    }

    public void setDamage(int d) {
        this.damage = d;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public void takeDamage(int d) {
        health -= d;
    }


}
