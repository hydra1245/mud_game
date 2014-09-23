package game.client;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class MudgameClient {
		public static class MudgameClientThread extends Thread{
			private BufferedReader br;
			public MudgameClientThread(BufferedReader br){
				this.br = br;
			}
			public void run(){
				try{
						while(true){
							String showServerMessage = br.readLine();
							System.out.println(showServerMessage);
						}
				}catch(IOException e){
					
				}
		}
		}
	public static void main(String[] args) {
		try{
			Socket sock = new Socket("127.0.0.1", 10001);
			BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));
			OutputStream out = sock.getOutputStream();
			InputStream in = sock.getInputStream();
			BufferedWriter pw = new BufferedWriter(new OutputStreamWriter(out));
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			String line = null;
			MudgameClient.MudgameClientThread mct = new MudgameClient.MudgameClientThread(br);
			mct.start();
			while(true){
				line = keyboard.readLine();
				if(line.equals("quit")) break;
				pw.write(line +  "\n");
				pw.flush();
			}
				pw.close();
				br.close();
				sock.close();
		}catch(Exception e){
			System.out.println(e);
		}
	}
}

