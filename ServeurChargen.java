package tp2;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

public class ServeurChargen {
	
	ServerSocket servSocket;
	Socket socket;
	Date d = new Date();
	
	public ServeurChargen(int port){
		try {
			servSocket = new ServerSocket(port);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("["+d.getHours()+":"+d.getMinutes()+":"+d.getSeconds()+"] : Ouverture du serveur Chargen au port "+port+".");
	}
	
	public void launch_chargen(){
		OutputStream out=null;
		PrintWriter writer;
		try {
			socket = servSocket.accept();
			out = socket.getOutputStream();
			System.out.println("["+d.getHours()+":"+d.getMinutes()+":"+d.getSeconds()+"] : Connexion établie pour le Chargen");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		writer = new PrintWriter(out, true);
		
		String chargen = "";
		while(1==1){
			for(int i=33; i<127; i++){
				writer.print((char)i);
				if(i==108){
					writer.println();
				}
			}
		}
			
	}
	
	public static void main(String[] args){
		ServeurChargen serv = new ServeurChargen(12345);
		serv.launch_chargen();
	}
}
