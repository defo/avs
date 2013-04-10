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
	public static final String HOST_NAME = "192.168.0.2";

	public static void main(String[] args) {
		try {
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter a number:");
			int userEntry = sc.nextInt();
			sc.close();

			Socket socket = new Socket(HOST_NAME, TCPServer.PORT_NUMBER);
			PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
			BufferedReader reader = new BufferedReader(new InputStreamReader(
					socket.getInputStream()));

			writer.println(userEntry);
			System.out.println("Client: " + userEntry);
			System.out.println("Server: " + reader.readLine());
			
			writer.close();
			reader.close();
			socket.close();
			
			System.out.println("*** DONE ****");

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
