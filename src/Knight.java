public class Knight extends Character {
    private int coins;
    private final String name;

    public int getCoins() {
        return coins;
    }


    public Knight(int health, int damage, int coins, int levels, String name) {

        health = Math.min(health, levels * 100);
        health = Math.max(health, 300);
        damage = Math.max(damage, 100);
        damage = Math.min(damage, 150);
        coins = Math.min(coins, 200 * levels);
        coins = Math.max(coins, 0);
        this.setHealth(health);
        this.setHealth(health);
        this.setDamage(damage);
        this.setDamage(damage);
        this.coins = coins;
        this.name = name;
    }

    public void payCoins(int sum) {
        coins -= sum;
    }

    @Override
    public String toString() {
        return name + "(HP:" + this.getHealth() + ",ATK:" + this.getDamage() + ",COINS:" + coins + ")";
    }
}
