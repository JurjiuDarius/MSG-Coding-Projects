public class Dragon extends Enemy {


    @Override
    public int randomHealth() {
        return random.nextInt(50) + 200;
    }

    public int randomGreed() {
        return random.nextInt(1000 - 800) + 800;
    }

    public Dragon() {
        super();

    }
}
