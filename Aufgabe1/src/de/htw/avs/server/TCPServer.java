package de.htw.avs.server;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

/**
 * @author: Sven Willrich, 534022
 * @author: ...
 * Date: 09.04.2013
 * Classname: TCPServer.java
 * Veranstaltung: AVS Uebung
 */

public class TCPServer {

	public static final int PORT_NUMBER = 4444;
	public static final int TIMEOUT = 60000*10;

	public static void main(String[] args) {
		System.out.println("*** SERVER STARTS ***");
		TCPServer server = new TCPServer();
		try {
			server.run();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void run() throws Exception {
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