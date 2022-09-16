public class Witch extends Enemy {


    @Override
    public int randomDamage() {
        return random.nextInt(40) + 10;
    }

    @Override
    public int randomGreed() {
        return random.nextInt(400) + 100;
    }

    public Witch() {
        super();

    }

}
