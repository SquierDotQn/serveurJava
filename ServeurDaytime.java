package tp2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

public class ServeurDaytime {
	
	ServerSocket servSocket;
	Socket socket;
	Date d = new Date();
	
	public ServeurDaytime(int port){
		try {
			servSocket = new ServerSocket(port);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("["+d.getHours()+":"+d.getMinutes()+":"+d.getSeconds()+"] : Ouverture du serveur Daytime au port "+port+".");
	}
	
	public void launch_daytime(){
		OutputStream out=null;
		PrintWriter writer;
		try {
			socket = servSocket.accept();
			out = socket.getOutputStream();
			System.out.println("["+d.getHours()+":"+d.getMinutes()+":"+d.getSeconds()+"] : Connexion établie pour le Daytime");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		writer = new PrintWriter(out, true);
		writer.println(d);
	}
	
	public static void main(String[] args){
		ServeurDaytime serv = new ServeurDaytime(12346);
		serv.launch_daytime();
	}
}
