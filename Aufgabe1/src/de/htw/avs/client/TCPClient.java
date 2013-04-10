package de.htw.avs.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

import de.htw.avs.server.TCPServer;

/**
 * @author: Sven Willrich, 534022
 * @author: ...defo Date: 09.04.2013 Classname: TCPClient.java Veranstaltung:
 *          AVS Uebung
 */

public class TCPClient {
	public static final String HOST_NAME = "141.45.192.55";

	public static void main(String[] args) {
		try {
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter a number:");
			int userEntry = sc.nextInt();
			
			Socket socket = new Socket(HOST_NAME, TCPServer.PORT_NUMBER);
			PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
			BufferedReader reader = new BufferedReader(new InputStreamReader(
					socket.getInputStream()));
			
			writer.print(userEntry);
			writer.flush();
			System.out.println("Client: " + userEntry);
			System.out.println("Server: " + reader.readLine());
			
			reader.close(); writer.close(); socket.close(); sc.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
