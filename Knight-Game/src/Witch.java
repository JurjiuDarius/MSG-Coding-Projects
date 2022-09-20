public class Witch extends Enemy {
    private static final int MIN_DAMAGE = 10, MAX_DAMAGE = 50;
    private static final int MIN_GREED = 100, MAX_GREED = 500;

    public Witch() {
        super();
    }

    @Override
    public int randomDamage() {
        return random.nextInt(MAX_DAMAGE - MIN_DAMAGE) + MIN_DAMAGE;
    }

    @Override
    public int randomGreed() {
        return random.nextInt(MAX_GREED - MIN_GREED) + MIN_GREED;
    }


}
