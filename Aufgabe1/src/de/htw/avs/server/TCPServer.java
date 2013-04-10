package de.htw.avs.server;

import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author: Sven Willrich, 534022
 * @author: defo
 * Date: 09.04.2013
 * Classname: TCPServer.java
 * Veranstaltung: AVS Uebung
 */

public class TCPServer {

	public static final int PORT_NUMBER = 4444;
	public static final int TIMEOUT = 60000 * 10;

	public static void main(String[] args) {
		System.out.println("*** SERVER STARTS ***");
		try {
			new TCPServer();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Startet den Server und akzeptiert endlos neue Clients
	 */
	public TCPServer() throws Exception {
		ServerSocket sSocket = new ServerSocket(PORT_NUMBER);
		sSocket.setSoTimeout(TIMEOUT);

		while (true) {
			System.out.println("*** WAITING FOR SOCKET BINDING ***");
			Socket socket = sSocket.accept();
			System.out.println("*** SOCKET BINDING FROM + "
					+ socket.getRemoteSocketAddress() + " ***");
			new ServerThread(socket);
		}
	}
}