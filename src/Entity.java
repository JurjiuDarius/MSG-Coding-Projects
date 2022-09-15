public class Entity {

    protected int health;
    protected int damage;
    protected String name;

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public void take_damge(int d)
    {
        health-=d;
    }
    public void deal_damage(Entity other)
    {
        other.health-=damage;
    }
    public String getName()
    {
        return name;
    }
}
