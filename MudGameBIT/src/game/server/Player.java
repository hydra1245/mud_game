package game.server;

import java.util.ArrayList;

public class Player extends Unit {
	int hp = 200; //ü��
	int level = 1; //ĳ���� ����
	int area = 1; //����
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
	public void attack() { // �Ϲݰ���
		// TODO Auto-generated method stub
		System.out.println("�Ϲݰ���");
	}
	public void useItem(int sel){ //������ ���
		
		System.out.println("�������� ���");
	}
	public void move(){ //�̵�
		this.distance++;
		System.out.println("�̵��մϴ�.");
	}
	public void skillAttack(int sel){ //��ų ���
		int damage = (int)(Math.random() * (20-10+1))+10; //��������
		System.out.println(damage);
	}
	public void levelUp(){
		
	}
	
}
