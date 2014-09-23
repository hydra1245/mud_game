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
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

public class MudgameServer {
		 static int playerCount = 0;
	public static void main(String[] args) {
		try{
			ServerSocket server = new ServerSocket(10001);
			System.out.println("������ ��ٸ��ϴ�.");
			HashMap hm = new HashMap();
			while(true){
				Socket sock = server.accept();
				playerCount++;
				System.out.println("playercount :"  +playerCount);
				MudgameServerThread mgst = new MudgameServerThread(sock,hm);
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
	private HashMap hm;
	//private boolean lineInput = true;
	public MudgameServerThread(Socket sock,HashMap hm){
		this.sock = sock;
		this.hm = hm;
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
				int playerCount = 0;
				pw.println(init);
				pw.flush();
				/*while(lineInput){
					line = br.readLine();
					lineInput = false;
					break;
				}*/
				while((line = br.readLine())!=null){
					//line = br.readLine();
					System.out.println("���� �Է� : " + line);
					if(line.equals("1") && progress == 1){
						pw.println(characterInit());
						pw.flush();
						//lineInput = true;
						progress = 2;
					}else if(progress == 2){
						p = new Player(line);
						hm.put(p.name, pw);
						gameIntro();
						pw.println("ĳ���͸� : " +p.name);
						pw.flush();
						if(MudgameServer.playerCount == 4){
							sendToAllMessage("�÷��̾ ��� �����Ͽ����ϴ�. ������ �����մϴ�.");
							progress = 3;
						}
					}
				}
		}catch(Exception ex){
			System.out.println(ex);
		}
	}
	public void sendToAllMessage(String message){
		synchronized(hm){
			Collection collection = hm.values();
			Iterator iter = collection.iterator();
			while(iter.hasNext()){
				PrintWriter pw = (PrintWriter) iter.next();
				pw.println(message);
				pw.flush();
			}
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
		pw.println("ĳ���Ͱ� �����Ǿ����ϴ�. : �ٸ� �÷��̾ ������ �� ���� ����մϴ�." );
		pw.flush();
		
	}
	
	public void monsterInit(){
		Monster MonsterJava = new Monster("java",100);
		Monster MonsterOracle = new Monster("Oracle",100);
		Monster MonsterNetwork = new Monster("Network",120);
		Monster MonsterJSP = new Monster("JSP",130);
		Monster MonsterXML = new Monster("XML",130);
		Monster MonsterAjax = new Monster("Ajax",130);
		Monster MonsterStruts = new Monster("Struts",170);
		Monster MonsterSpring = new Monster("Spring",170);
		Monster Boss = new Monster("Chohyunjung",200);
	}
}