package Game.Casting;

public class Actor {
    int speed;
    int health;
    int attackDamage;
    Position position;

    public Actor(int x, int y)
    {
        position = new Position(x, y);
    }

    public void MoveActor()
    {

    }

    public Position GetPosition()
    {
        return position;
    }

    public int GetSpeed()
    {
        return speed;
    }

    public int GetHealth()
    {
        return health;
    }

    public int GetAttackDamage()
    {
        return attackDamage;
    }

}
