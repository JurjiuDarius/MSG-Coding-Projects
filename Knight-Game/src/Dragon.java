public class Dragon extends Enemy {

    public static final int MIN_HEALTH = 50, MAX_HEALTH = 200;
    public static final int MIN_GREED = 800, MAX_GREED = 1000;

    public Dragon() {
        super();
    }

    @Override
    public int randomHealth() {
        return random.nextInt(MAX_HEALTH - MIN_HEALTH) + MIN_HEALTH;
    }

    @Override
    public int randomGreed() {
        return random.nextInt(MAX_GREED - MIN_GREED) + MIN_GREED;
    }


}
