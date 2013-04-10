package de.htw.avs.client;

import java.io.IOException;
import java.net.Socket;

/**
 * @author: Sven Willrich, 534022
 * @author: ...
 * Date: 09.04.2013
 * Classname: TCPClient.java
 * Veranstaltung: AVS Übung
 */

public class TCPClient {
	public static final int PORT_NUMBER = 4444;
	public static final String HOST_NAME = "localhost";
	
	public static void main(String[] args) throws IOException {
		Socket socket = new Socket(HOST_NAME, PORT_NUMBER);
		
	}
}
