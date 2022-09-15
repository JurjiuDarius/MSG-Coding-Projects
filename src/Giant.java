import java.util.Random;

public class Giant extends Enemy{
    private Random random=new Random();
    public Giant()
    {

        minDamage=50;
        maxDamage=200;
        minGreed=100;
        maxGreed=500;
        this.health=random.nextInt(maxHealth-minHealth)+minHealth;
        this.damage=random.nextInt(maxDamage-minDamage)+minDamage;
        this.greed=random.nextInt(maxGreed-minGreed)+minGreed;
        this.distraction=random.nextInt(maxhDistraction-minDistraction)+minDistraction;
        this.name="Giant";
    }
}
