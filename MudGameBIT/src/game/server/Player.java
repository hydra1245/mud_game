package game.server;

public class Player extends Unit {

	@Override
	public void attack() { // �Ϲݰ���
		// TODO Auto-generated method stub
		System.out.println("�Ϲݰ���");
	}
	public void useItem(int sel){ //������ ���
		
		System.out.println("�������� ���");
	}
	public void move(Player p){ //�̵�
		p.distance++;
		System.out.println("�̵��մϴ�.");
	}
	public void skillAttack(int sel){ //��ų ���
		int damage = (int)(Math.random() * (20-10+1))+10; //��������
		System.out.println(damage);
	}
	
}
