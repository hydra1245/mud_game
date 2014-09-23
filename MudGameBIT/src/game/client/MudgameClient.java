package game.client;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public class MudgameClient {
		
	
	public static void main(String[] args) {
		try{
			Socket sock = new Socket("127.0.0.1", 10001);
			BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));
			OutputStream out = sock.getOutputStream();
			InputStream in = sock.getInputStream();
			PrintWriter pw = new PrintWriter(new OutputStreamWriter(out));
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			String line = null;
			
			while(true){
				
				String echo = br.readLine();
				String[] echo_split = echo.split(":");
					for(int i = 0 ; i<echo_split.length;i++){
						System.out.println(echo_split[i]);
					}
				line = keyboard.readLine();
				if(line.equals("quit")) break;
				pw.println(line);
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
