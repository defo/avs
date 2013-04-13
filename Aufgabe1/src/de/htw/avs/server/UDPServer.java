package de.htw.avs.server;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

import de.htw.avs.util.Log;

/**
 * @author: Sven Willrich, 534022
 * @author: defo
 * Date: 10.04.2013
 * Classname: UDPServer.java
 * Veranstaltung: AVS Exercise
 */

public class UDPServer {

	public final static int HOSTPORT = 4445;

	/**
	 * Instantiated a new UDPServer object
	 */
	public static void main(String[] args) {
		try {
			new UDPServer();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Starts a UDPServer
	 */
	public UDPServer() throws Exception {
		Log.write("UDP SERVER STARTS");
		byte[] buf = new byte[265];
		DatagramSocket socket = new DatagramSocket(HOSTPORT);
		while (true) {
			DatagramPacket packet = new DatagramPacket(buf, buf.length);
			Log.write("TRY TO RECEIVE PACKET");
			socket.receive(packet);
			Log.write("GET PACKET");
			String clientData = new String(packet.getData());
			System.out.println(clientData);
		}
	}
}
