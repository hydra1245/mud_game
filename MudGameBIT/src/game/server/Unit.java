package game.server;

public abstract class Unit {
	static int distance;
	int energy;
	final static int max_damage = 20;
	final static int min_damage = 10;
	abstract public void attack();
}
