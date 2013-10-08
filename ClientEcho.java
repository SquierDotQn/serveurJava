package tp2;

import java.io.*;
import java.net.*;

public class ClientEcho {
	Socket connexion;

	public ClientEcho(String ip, int port){
		try {
			connexion = new Socket(ip, port);
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public ClientEcho(String ip){
		this(ip, 7);
	}
	
	public String echo(){
		BufferedReader lectureClavier = new BufferedReader(new InputStreamReader(System.in));
		String str = "";
		InputStream is = null;
		OutputStream os = null;
		BufferedReader reader = null;
		PrintWriter out = null;
		try {
			os = connexion.getOutputStream();
			out = new PrintWriter(os,true);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		//System.out.println("os connecté");
		
		try {
			is = connexion.getInputStream();
			reader = new BufferedReader(new InputStreamReader(is));
		} catch (IOException e) {
			e.printStackTrace();
		}
		//System.out.println("is connecté");
		
		try {
			out.println(lectureClavier.readLine());
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		//System.out.println("out envoyé");
		
		try {
			str = reader.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		//System.out.println("Reader récupéré");
		
		return str;
	}
	
	public static void main(String[] args){
		ClientEcho client = new ClientEcho("saule01",7);
		System.out.println(client.echo());
	}
	
}
