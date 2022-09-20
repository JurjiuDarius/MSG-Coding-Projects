import java.util.Random;

public class Enemy extends Character {


    private static final int MIN_HEALTH = 50, MAX_HEALTH = 250;
    private static final int MIN_DAMAGE = 20, MAX_DAMAGE = 150;
    private static final int MIN_GREED = 100, MAX_GREED = 1000;
    private static final int MIN_DISTRACTION = 0, MAX_DISTRACTION = 100;
    protected Random random = new Random();
    private int greed;
    private int distraction;

    public Enemy() {
        this.setHealth(randomHealth());
        this.setDamage(randomDamage());
        this.setGreed(randomGreed());
        this.setDistraction(randomDistraction());
    }

    public int randomHealth() {
        return random.nextInt(MAX_HEALTH - MIN_HEALTH) + MIN_HEALTH;
    }

    public int randomDamage() {
        return random.nextInt(MAX_DAMAGE - MIN_DAMAGE) + MIN_DAMAGE;
    }

    public int randomDistraction() {
        return random.nextInt(MAX_DISTRACTION - MIN_DISTRACTION) + MIN_DISTRACTION;
    }

    public int randomGreed() {
        return random.nextInt(MAX_GREED - MIN_GREED) + MIN_GREED;
    }

    public void setDistraction(int distraction) {
        this.distraction = distraction;
    }

    public boolean wasDistracted() {
        return Math.random() * 100 < distraction;
    }

    public int getGreed() {
        return greed;
    }

    public void setGreed(int greed) {
        this.greed = greed;
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + "(HP:" + super.getHealth() + ",ATK:" + super.getDamage() + ",GREED:" + this.getGreed() + ",DISTRACTION:" + this.distraction + ")";
    }
}
