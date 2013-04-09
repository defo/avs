package de.htw.avs.server;

import java.util.Random;

/**
 * @author: Sven Willrich, 534022
 * @author: ...
 * Date: 09.04.2013
 * Classname: TCPServer.java
 * Veranstaltung: AVS �bung
 */

public class TCPServer {
	public static void main(String[] args) {
		TCPServer s = new TCPServer();
		System.out.println(s.getRandomString());
	}

	/**
	 * Sendet eine zuf�llige Zeichenkette mit einer 
	 * L�nge zwischen 1 - 20 Zeichen zur�ck
	 * gefolgt von einer Zahl z + 1
	 */
	private String getRandomString() {
		Random r = new Random();
		String randomString = "";
		for (int i = 0; i < 20; i++) {
			int charInt = r.nextInt(24);
			randomString += (char) (97 + charInt);
		}
		return randomString;
	}
}