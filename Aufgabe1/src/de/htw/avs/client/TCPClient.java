package de.htw.avs.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

/**
 * @author: Sven Willrich, 534022
 * @author: ...defo Date: 09.04.2013 Classname: TCPClient.java Veranstaltung:
 *          AVS Uebung
 */

public class TCPClient {
	public static final int PORT_NUMBER = 4444;
	public static final String HOST_NAME = "localhost";

	public static void main(String[] args) {
		try {
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter a number:");
			int userEntry = sc.nextInt();
			
			Socket socket = new Socket(HOST_NAME, PORT_NUMBER);
			PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
			BufferedReader reader = new BufferedReader(new InputStreamReader(
					socket.getInputStream()));
			
			writer.write(userEntry);
			System.out.println("Client: " + userEntry);
			System.out.println("Server: " + reader.readLine());
			
			reader.close(); writer.close(); socket.close(); sc.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
