package game.server;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class MudgameServer {
	
	public static void main(String[] args) {
		try{
			ServerSocket server = new ServerSocket(10001);
			System.out.println("������ ��ٸ��ϴ�.");
			
			while(true){
				Socket sock = server.accept();
				MudgameServerThread mgst = new MudgameServerThread(sock);
				mgst.start();
			}
	}catch(Exception e){
		System.out.println(e);
	}
	}
}
class MudgameServerThread extends Thread{
	private Socket sock;
	private int progress = 1;
	private static InputStream in;
	private static OutputStream out;
	private static PrintWriter pw;
	private static BufferedReader br;
	public MudgameServerThread(Socket sock){
		this.sock = sock;
		
	}
	
	public void run(){
		try{
				InetAddress inetaddr = sock.getInetAddress();
				System.out.println(inetaddr.getHostAddress() + " �� ���� �����Ͽ����ϴ�.");
				out = sock.getOutputStream();
				in = sock.getInputStream();
				pw = new PrintWriter(new OutputStreamWriter(out));
				br = new BufferedReader(new InputStreamReader(in));
				String line = null;
				String init = init();
				Player p;
				pw.println(init);
				pw.flush();
				while(true){
					line = br.readLine();
					System.out.println("���� �Է� : " + line);
					if(line.equals("1") && progress == 1){
						pw.println(characterInit());
						pw.flush();
						progress = 2;
					}else if(progress == 2){
						p = new Player(line);
						gameIntro();
						progress = 3;
						//pw.println("ĳ���͸� : " +p.name);
					}
				}
		}catch(Exception ex){
			System.out.println(ex);
		}
	}
	public String init(){
		String commandlist = " 1. ĳ���� ����  2. ����"; 
		return commandlist;
	}
	public String characterInit(){
		String commandlist = "ĳ���� ���� �Է����ּ���.";
		return commandlist;
	}
	public void gameIntro(){
		System.out.println("2222");
		monsterInit();
		String story = "�������� ���� �ȱ� ����.....";
		System.out.println(story);
		pw.print("ĳ���Ͱ� �����Ǿ����ϴ�.");
		pw.println(story);
		pw.flush();
	}
	public void monsterInit(){
		Monster MonsterJava = new Monster("java",100);
		Monster MonsterOracle = new Monster("Oracle",100);
		Monster MonsterBossChaheejin = new Monster("������",120);
		Monster MonsterNetwork = new Monster("Network",130);
		Monster MonsterJSP = new Monster("JSP",130);
		Monster MonsterBossLimjihun = new Monster("������",170);
		Monster Boss = new Monster("Chohyunjung",200);
	}
}