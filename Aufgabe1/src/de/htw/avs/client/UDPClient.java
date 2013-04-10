package de.htw.avs.client;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Date;
import java.util.Random;

import de.htw.avs.server.UDPServer;

/**
 * @author: Sven Willrich, 534022
 * @author: ...
 * Date: 10.04.2013
 * Classname: UDPClient.java
 * Veranstaltung: AVS Übung
 */

public class UDPClient extends Thread {

	private final static String HOSTADDR = "192.168.0.4";
	
	public static void main(String[] args) {
		new UDPClient().run();
	}

	/* (non-Javadoc)
	 * @see java.lang.Thread#run()
	 */
	@Override
	public void run() {
		try {
			DatagramSocket socket = new DatagramSocket();
			byte[] buf = new byte[265];
			while (true) {
				String data = new Random().nextInt() + " + "
						+ new Date().toString();
				buf = data.getBytes();
				DatagramPacket packet = new DatagramPacket(buf, buf.length,
						InetAddress.getByName(HOSTADDR), UDPServer.HOSTPORT);
				socket.send(packet);
				Thread.sleep(1000 * 5);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
