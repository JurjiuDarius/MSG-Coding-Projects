import java.util.Random;

public class Enemy extends Character {

    private int greed;
    private int distraction;
    private final int minHealth = 50, maxHealth = 250;
    private final int minDamage = 20, maxDamage = 150;
    private final int minGreed = 100, maxGreed = 1000;
    private final int minDistraction = 0, maxhDistraction = 100;

    protected Random random = new Random();

    public int randomHealth() {
        return random.nextInt(maxHealth - minHealth) + minHealth;
    }

    public int randomDamage() {
        return random.nextInt(maxDamage - minDamage) + minDamage;
    }

    public int randomDistraction() {
        return random.nextInt(maxhDistraction - minDistraction) + minDistraction;
    }

    public int randomGreed() {
        return random.nextInt(maxGreed - minGreed) + minGreed;
    }


    public void setGreed(int greed) {
        this.greed = greed;
    }

    public void setDistraction(int distraction) {
        this.distraction = distraction;
    }

    public Enemy() {

        this.setHealth(randomHealth());
        this.setDamage(randomDamage());
        this.setGreed(randomGreed());
        this.setDistraction(randomDistraction());

    }


    public boolean wasDistracted() {
        return Math.random() * 100 < distraction;
    }


    public int getGreed() {
        return greed;
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + "(HP:" + super.getHealth() + ",ATK:" + super.getDamage() + ",GREED:" + this.getGreed() + ",DISTRACTION:" + this.distraction + ")";
    }
}
