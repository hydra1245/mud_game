package game.server;

import java.util.ArrayList;

public class Player extends Unit {
	final static int MAX_SKILL_GATE = 50;
	static int distance;
	int level; //캐릭터 레벨
	int area; //지역
	int bombCount; //폭탄 갯수
	int potionCount; //포션 갯수
	int skillGage; //스킬 게이지
	
	public Player(String name){
		this.hp = 200;
		this.level = 1;
		this.area = 1;
		this.name = name;
		bombCount = 3;
		potionCount = 3;
		
	}
	@Override
	public void attack() { // 일반공격
		// TODO Auto-generated method stub
		System.out.println("일반공격");
	}
	public void useItem(int sel){ //아이템 사용
		
		System.out.println("아이템을 사용");
	}
	public static void move(){ //이동
		distance++;
		System.out.println("이동합니다.");
	}
	public void skillAttack(int sel){ //스킬 사용
		int damage = (int)(Math.random() * (20-10+1))+10; //랜덤숫자
		System.out.println(damage);
	}
	public void levelUp(){
		
	}
	
}
