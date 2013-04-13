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
 * Veranstaltung: AVS Exercise
 */

public class ServerThread extends Thread {

	private Socket socket;

	/**
	 * Stated the socket
	 */
	public ServerThread(Socket socket) {
		this.socket = socket;
		this.run();
		finish();
	}

	/**
	 * Server thread will started
	 * Increments the received integer with 1 and prepends a string.
	 * It is returned to the client as string.
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
	 * Socket will closed
	 */
	public void finish() {
		try {
			socket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Sends a random string with a length between 
	 * 1 - 20 chars back and appends a integer z + 1
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
