public class Giant extends Enemy {

    @Override
    public int randomHealth() {
        return random.nextInt(150) + 50;
    }

    @Override
    public int randomDistraction() {
        return random.nextInt(50) + 100;
    }

    public Giant() {
        super();

    }
}
