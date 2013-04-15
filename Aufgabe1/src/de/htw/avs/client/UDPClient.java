package de.htw.avs.client;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Date;
import java.util.Random;

import de.htw.avs.server.UDPServer;
import de.htw.avs.util.Log;

/**
 * @author: Sven Willrich, 534022
 * @author: defo
 * Date: 10.04.2013
 * Classname: UDPClient.java
 * Veranstaltung: AVS Exercise
 * Descritpion: This class represents the UDP client, who's sending UDP messages to the server
 * in regular intervals 
 */

public class UDPClient extends Thread {

	private final static String HOSTADDR = "192.168.0.2";
	
	public static void main(String[] args) {
		new UDPClient().start();
	}

	/**
	 * Send messages in five seconds intervals to the server
	 * The data is one random integer + the current data 
	 */
	@Override
	public void run() {
		Log.write("START CLIENT");
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
				Log.write("SENDED DATA + " + data);
				Thread.sleep(1000 * 5);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
