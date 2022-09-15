import java.util.Random;

public class Dragon extends Enemy{
    private Random random=new Random();
public Dragon()
{

    minHealth=200;
    maxHealth=250;
    minGreed=800;
    maxGreed=1000;
    this.health=random.nextInt(maxHealth-minHealth)+minHealth;
    this.damage=random.nextInt(maxDamage-minDamage)+minDamage;
    this.greed=random.nextInt(maxGreed-minGreed)+minGreed;
    this.distraction=random.nextInt(maxhDistraction-minDistraction)+minDistraction;
    this.name="Dragon";
}
}
