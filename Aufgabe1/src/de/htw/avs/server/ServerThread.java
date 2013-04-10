package de.htw.avs.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Random;

/**
 * @author: Sven Willrich, 534022
 * @author: defo
 * Date: 10.04.2013
 * Classname: ServerThread.java
 * Veranstaltung: AVS Übung
 */

public class ServerThread extends Thread {

	private Socket socket;

	/**
	 * Startet den Thread
	 */
	public ServerThread(Socket socket) {
		this.socket = socket;
		this.run();
		finish();
	}

	/** 
	 * Serverthrad wird gestartet. 
	 * Empfangene Zahl um 1 inkrementiert und es wird eine 
	 * zufällige Zeichenkette vorangestellt. 
	 * Als String wird es an den Client zurückgeschickt.
	 */
	@Override
	public void run() {
		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(
					socket.getInputStream()));
			PrintWriter writer = new PrintWriter(new OutputStreamWriter(
					socket.getOutputStream()), true);
			String line = null;
			while ((line = reader.readLine()) != null) {
				int integer = Integer.valueOf(line) + 1;
				System.out.println("RECEIVE FROM CLIENT: " + integer);
				String toClient = getRandomString() + integer;
				writer.println(toClient);
				System.out.println("SEND TO CLIENT: " + toClient);
			}
			reader.close();
			writer.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Socket wird geschlossen 
	 */
	public void finish() {
		try {
			socket.close();
		} catch (IOException e) {
			e.printStackTrace();
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
		for (int i = 0; i < (1 + r.nextInt(19)); i++) {
			int charInt = r.nextInt(24);
			randomString += (char) (97 + charInt);
		}
		return randomString;
	}
}
