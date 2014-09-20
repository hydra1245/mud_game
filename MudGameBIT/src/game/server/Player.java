package game.server;

public class Player extends Unit {

	@Override
	public void attack() { // 일반공격
		// TODO Auto-generated method stub
		System.out.println("일반공격");
	}
	public void useItem(int sel){ //아이템 사용
		
		System.out.println("아이템을 사용");
	}
	public void move(Player p){ //이동
		p.distance++;
		System.out.println("이동합니다.");
	}
	public void skillAttack(int sel){ //스킬 사용
		int damage = (int)(Math.random() * (20-10+1))+10; //랜덤숫자
		System.out.println(damage);
	}
	
}
