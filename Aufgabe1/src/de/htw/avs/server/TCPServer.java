package de.htw.avs.server;

import java.net.ServerSocket;
import java.net.Socket;

import de.htw.avs.util.Log;

/**
 * @author: Sven Willrich, 534022
 * @author: defo Bienvenue, 534195
 * Date: 09.04.2013
 * Classname: TCPServer.java
 * Veranstaltung: AVS Exercise
 * Descritpion: This class is a TCP server, which responds to the client 
 */

public class TCPServer {

	public static final int TCP_PORT_NUMBER = 4444;
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
	 * Started the client and accept new clients without any border
	 */
	public TCPServer() throws Exception {
		ServerSocket sSocket = new ServerSocket(TCP_PORT_NUMBER);
		sSocket.setSoTimeout(TIMEOUT);

		while (true) {
			Log.write("WAITING FOR SOCKET BINDING");
			Socket socket = sSocket.accept();
			Log.write("SOCKET BINDING FROM " + socket.getRemoteSocketAddress());
			((Thread)new ServerThread(socket)).start();
			Log.write("DONE");
		}
	}
}
