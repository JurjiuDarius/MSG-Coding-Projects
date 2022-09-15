import java.util.Random;

public class Knight extends Entity{
    private int levels,coins;
    private String name;

    public int getCoins() {
        return coins;
    }

    public void setCoins(int coins) {
        this.coins = coins;
    }

    Knight(int health, int damage, int coins, int levels, String name)
    {
        levels=Math.max(levels,3);
        health=Math.min(health,levels*100);
        health=Math.max(health,300);
        damage=Math.min(damage,150);
        damage=Math.max(damage,100);
        this.health=health;
        this.damage=damage;
        this.coins=coins;
        this.name=name;
    }
    public void pay_coins(int sum)
    {
        coins-=sum;
    }
    public String toString()
    {
        return name+"(HP:"+health+",ATK:"+damage+",COINS:"+coins+")";
    }
}
