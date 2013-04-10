package de.htw.avs.server;

import java.net.ServerSocket;
import java.net.Socket;

import de.htw.avs.util.Log;

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
		Log.write("SERVER STARTS");
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

		Log.write("WAITING FOR SOCKET BINDING");
		Socket socket = sSocket.accept();
		Log.write("SOCKET BINDING FROM " + socket.getRemoteSocketAddress());
		new ServerThread(socket);
		Log.write("DONE");
	}
}