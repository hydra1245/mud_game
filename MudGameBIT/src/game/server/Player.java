package game.server;

import java.util.ArrayList;

public class Player extends Unit {
	final static int MAX_SKILL_GATE = 50;
	static int distance;
	int level; //ĳ���� ����
	int area; //����
	int bombCount; //��ź ����
	int potionCount; //���� ����
	int skillGage; //��ų ������
	
	public Player(String name){
		this.hp = 200;
		this.level = 1;
		this.area = 1;
		this.name = name;
		bombCount = 3;
		potionCount = 3;
		
	}
	@Override
	public void attack() { // �Ϲݰ���
		// TODO Auto-generated method stub
		System.out.println("�Ϲݰ���");
	}
	public void useItem(int sel){ //������ ���
		
		System.out.println("�������� ���");
	}
	public static void move(){ //�̵�
		distance++;
		System.out.println("�̵��մϴ�.");
	}
	public void skillAttack(int sel){ //��ų ���
		int damage = (int)(Math.random() * (20-10+1))+10; //��������
		System.out.println(damage);
	}
	public void levelUp(){
		
	}
	
}
