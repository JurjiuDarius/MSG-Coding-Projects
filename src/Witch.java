import java.util.Random;

public class Witch extends Enemy{
    private Random random=new Random();
    Witch()
    {

        minDamage=10;
        maxDamage=50;
        minGreed=100;
        maxGreed=500;
        this.health=random.nextInt(maxHealth-minHealth)+minHealth;
        this.damage=random.nextInt(maxDamage-minDamage)+minDamage;
        this.greed=random.nextInt(maxGreed-minGreed)+minGreed;
        this.distraction=random.nextInt(maxhDistraction-minDistraction)+minDistraction;
        this.name="Witch";



    }
}
