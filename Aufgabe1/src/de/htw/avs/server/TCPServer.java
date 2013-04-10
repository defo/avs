package de.htw.avs.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Random;

/**
 * @author: Sven Willrich, 534022
 * @author: ...
 * Date: 09.04.2013
 * Classname: TCPServer.java
 * Veranstaltung: AVS Uebung
 */

public class TCPServer {
	
	public static final int PORT_NUMBER = 4444;
	
	public static void main(String[] args) {
		TCPServer server = new TCPServer();
		try {
			server.run();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void run() throws Exception {
		ServerSocket sSocket = new ServerSocket(PORT_NUMBER);
		
		while (true) {
			Socket socket = sSocket.accept();
			BufferedReader br = new BufferedReader(new InputStreamReader(
					socket.getInputStream()));
			PrintWriter writer = new PrintWriter(new OutputStreamWriter(
					socket.getOutputStream()));
			String clientData = "";
			while ((clientData = br.readLine()) != null) {
				String toClient = getRandomString() + clientData;
				writer.write(toClient);
				System.out.println(toClient);
				sSocket.close();
			}
			socket.close(); br.close(); writer.close();
		}
	}

	/**
	 * Sendet eine zufaellige Zeichenkette mit einer 
	 * Laenge zwischen 1 - 20 Zeichen zurueck
	 * gefolgt von einer Zahl z + 1
	 */
	private String getRandomString() {
		Random r = new Random();
		String randomString = "";
		for (int i = 0; i < r.nextInt(20); i++) {
			int charInt = r.nextInt(24);
			randomString += (char) (97 + charInt);
		}
		return randomString;
	}
}