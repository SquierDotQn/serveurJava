package tp2;

import java.io.*;
import java.net.*;

public class ClientChargen {
	Socket connexion;

	public ClientChargen(String ip, int port){
		try {
			connexion = new Socket(ip, port);
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	public ClientChargen(String ip){
		this(ip, 19);
	}
	
	public String getChargen(){
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
		ClientChargen client = new ClientChargen("saule01",19);
		System.out.println(client.getChargen());
	}
	
}
