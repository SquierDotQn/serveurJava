package tp2;

import java.io.*;
import java.net.*;

public class ClientDaytime {
	Socket connexion;

	public ClientDaytime(String ip, int port){
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
	
	public ClientDaytime(String ip){
		this(ip, 13);
	}
	
	public String getDate(){
		InputStream is = null;
		String str = "";
		try {
			is = connexion.getInputStream();
		} catch (IOException e) {
			e.printStackTrace();
		}
		BufferedReader reader = new BufferedReader(new InputStreamReader(is));
		try {
			str = reader.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return str;
	}
	
	public static void main(String[] args){
		ClientDaytime client = new ClientDaytime("saule01",13);
		System.out.println(client.getDate());
	}
	
}
