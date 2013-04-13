package de.htw.avs.client;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

import de.htw.avs.server.TCPServer;
import de.htw.avs.util.Log;

/**
 * @author: Sven Willrich, 534022
 * @author: defo 
 * Date: 09.04.2013 
 * Classname: TCPClient.java 
 * Veranstaltung: AVS Exercise
 */

public class TCPClient {
	public static final String HOST_NAME = "192.168.0.2";

	/**
	 * Instantiated a TCPClient object
	 */
	public static void main(String[] args) {
		try {
			new TCPClient();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Recieved user inputs and 
	 * send a message to the server
	 */
	public TCPClient() throws Exception {
		int userEntry = getUserEntry();
		sendMessage(String.valueOf(userEntry));
	}

	/**
	 * Sends a message to the server
	 */
	public void sendMessage(String msg) throws Exception {
		Socket socket = new Socket(HOST_NAME, TCPServer.TCP_PORT_NUMBER);
		PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
		BufferedReader reader = new BufferedReader(new InputStreamReader(
				socket.getInputStream()));

		writer.println(msg);
		System.out.println("Client: " + msg);
		System.out.println("Server: " + reader.readLine());

		writer.close();
		reader.close();
		socket.close();

		Log.write("DONE");
	}
	
	/**
	 * Requests the user for input and return this
	 */
	private int getUserEntry() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter a number:");
		int userEntry = sc.nextInt();
		sc.close();
		return userEntry;
	}
}
