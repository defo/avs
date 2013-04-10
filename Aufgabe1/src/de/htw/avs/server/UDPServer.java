package de.htw.avs.server;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 * @author: Sven Willrich, 534022
 * @author: ...
 * Date: 10.04.2013
 * Classname: UDPServer.java
 * Veranstaltung: AVS Übung
 */

public class UDPServer {

	public final static int HOSTPORT = 4445;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			new UDPServer();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 
	 */
	public UDPServer() throws Exception {
		byte[] buf = new byte[265];
		DatagramSocket socket = new DatagramSocket(HOSTPORT);
		while (true) {
			DatagramPacket packet = new DatagramPacket(buf, buf.length);
			socket.receive(packet);
			String clientData = new String(packet.getData());
			System.out.println(clientData);
		}
	}
}
