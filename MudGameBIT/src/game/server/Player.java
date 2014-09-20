package game.server;

public class Player extends Unit {

	@Override
	public void attack() {
		// TODO Auto-generated method stub
		
	}
	public void useItem(int sel){
		
	}
	public void move(Unit u){
		u.distance++;
		System.out.println("이동합니다.");
	}
	public void skillAttack(int sel){
		int damage = (int)(Math.random() * (20-10+1))+10;
		System.out.println(damage);
	}
	
}
