package de.htw.avs.server;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Random;

import de.htw.avs.util.Log;

/**
 * @author: Sven Willrich, 534022
 * @author: defo Bienvenue ,534195
 * Date: 10.04.2013
 * Classname: ServerThread.java
 * Veranstaltung: AVS Exercise
 * Descritpion: This class is a server thread, which start a new thread with a socket instance
 */

public class ServerThread extends Thread {

	private Socket socket;

	/**
	 * Stated the socket
	 * @param the socket
	 */
	public ServerThread(Socket socket) {
		this.socket = socket;
	}

	/**
	 * Server thread will started
	 * Increments the received integer by 1 and prepends a string.
	 * It is returned to the client as string.
	 */
	@Override
	public void run() {
		try {
			Log.write("THREAD STARTS");
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
			socket.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Sends a random string with a length between 
	 * 1 - 20 chars back
	 * @return the random string
	 */
	private String getRandomString() {
		Random r = new Random();
		String randomString = "";
		for (int i = 0; i < (1 + r.nextInt(19)); i++) {
			randomString += (char) (33 + r.nextInt(93));
		}
		return randomString;
	}
}
