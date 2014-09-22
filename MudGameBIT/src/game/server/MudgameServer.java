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
			System.out.println("접속을 기다립니다.");
			
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
				System.out.println(inetaddr.getHostAddress() + " 로 부터 접속하였습니다.");
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
					System.out.println("들어온 입력 : " + line);
					if(line.equals("1") && progress == 1){
						pw.println(characterInit());
						pw.flush();
						progress = 2;
					}else if(progress == 2){
						p = new Player(line);
						gameIntro();
						progress = 3;
						//pw.println("캐릭터명 : " +p.name);
					}
				}
		}catch(Exception ex){
			System.out.println(ex);
		}
	}
	public String init(){
		String commandlist = " 1. 캐릭터 생성  2. 종료"; 
		return commandlist;
	}
	public String characterInit(){
		String commandlist = "캐릭터 명을 입력해주세요.";
		return commandlist;
	}
	public void gameIntro(){
		System.out.println("2222");
		monsterInit();
		String story = "개발자의 길을 걷기 위해.....";
		System.out.println(story);
		pw.print("캐릭터가 생성되었습니다.");
		pw.println(story);
		pw.flush();
	}
	public void monsterInit(){
		Monster MonsterJava = new Monster("java",100);
		Monster MonsterOracle = new Monster("Oracle",100);
		Monster MonsterBossChaheejin = new Monster("차희진",120);
		Monster MonsterNetwork = new Monster("Network",130);
		Monster MonsterJSP = new Monster("JSP",130);
		Monster MonsterBossLimjihun = new Monster("임지훈",170);
		Monster Boss = new Monster("Chohyunjung",200);
	}
}