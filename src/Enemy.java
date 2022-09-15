import java.util.Random;

public class Enemy extends Entity{

    protected int greed;
    protected int distraction;
    protected int minHealth=50,maxHealth=250;
    protected int minDamage=50,maxDamage=250;
    protected int minGreed=50,maxGreed=250;
    protected int minDistraction=0,maxhDistraction=100;

    public int getGreed() {
        return greed;
    }

    public void setGreed(int greed) {
        this.greed = greed;
    }

    public boolean wasDistracted()
    {
        return Math.random()*100<distraction;
    }
    public String toString()
    {
        return name+"(HP:"+health+",ATK:"+damage+",GREED:"+greed+",DISTRACTION:"+distraction+")";
    }
}
