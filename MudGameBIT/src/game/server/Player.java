package game.server;

import java.util.ArrayList;

public class Player extends Unit {
	int hp = 200; //체력
	int level = 1; //캐릭터 레벨
	int area = 1; //지역
	String name=null;
	
	private ArrayList<Player> playerList = new ArrayList<Player>();
	public Player(String name){
		this.hp = 200;
		this.level = 1;
		this.area = 1;
		this.name = name;
		playerList.add(this);
	}
	@Override
	public void attack() { // 일반공격
		// TODO Auto-generated method stub
		System.out.println("일반공격");
	}
	public void useItem(int sel){ //아이템 사용
		
		System.out.println("아이템을 사용");
	}
	public void move(){ //이동
		this.distance++;
		System.out.println("이동합니다.");
	}
	public void skillAttack(int sel){ //스킬 사용
		int damage = (int)(Math.random() * (20-10+1))+10; //랜덤숫자
		System.out.println(damage);
	}
	public void levelUp(){
		
	}
	
}
