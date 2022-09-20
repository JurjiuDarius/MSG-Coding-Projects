public class Giant extends Enemy {

    private static final int MIN_HEALTH = 50, MAX_HEALTH = 200;
    private static final int MIN_DISTRACTION = 50, MAX_DISTRACTION = 150;

    public Giant() {
        super();
    }

    @Override
    public int randomHealth() {
        return random.nextInt(MAX_HEALTH - MIN_HEALTH) + MIN_HEALTH;
    }

    @Override
    public int randomDistraction() {
        return random.nextInt(MAX_DISTRACTION - MIN_DISTRACTION) + MIN_DISTRACTION;
    }


}
