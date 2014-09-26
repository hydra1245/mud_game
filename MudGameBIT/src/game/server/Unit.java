package game.server;

public abstract class Unit {
	protected String name;
	protected int hp;
	protected int max_damage;
	protected int min_damage;
	protected String Name;
	abstract public void attack();
}
