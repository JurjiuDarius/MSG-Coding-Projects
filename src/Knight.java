public class Knight extends Character {
    private int coins;
    private final String name;

    public Knight(int health, int damage, int coins, int levels, String name) {
        this.setHealth(health);
        this.setDamage(damage);
        this.coins = coins;
        this.name = name;
        setAttributeLimits(levels);
    }


    public int getCoins() {
        return coins;
    }


    public void payCoins(int sum) {
        coins -= sum;
    }

    @Override
    public String toString() {
        return name + "(HP:" + this.getHealth() + ",ATK:" + this.getDamage() + ",COINS:" + coins + ")";
    }

    private void setAttributeLimits(int levels) {
        this.setHealth(Math.min(getHealth(), levels * 100));
        this.setHealth(Math.max(getHealth(), levels * 100));
        setDamage(Math.max(getDamage(), 100));
        setDamage(Math.min(getDamage(), 100));
        coins = Math.min(coins, 200 * levels);
        coins = Math.max(coins, 0);
    }
}
