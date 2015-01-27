

import java.awt.AWTException;
import java.awt.Robot;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

import javax.swing.plaf.SliderUI;

public class SocketConnector {

	// umjesto 127.0.0.1. moze i localHost
	public static final String serverAdress = "127.0.0.1";
	// port mora biti isti ako i kod servera!!
	public static final int port = 1728;

	/**
	 * 
	 * @throws UnknownHostException
	 * @throws IOException
	 * @throws AWTException 
	 */

	private static void connectToServer() throws UnknownHostException,
			IOException, AWTException {

		Socket client = new Socket(serverAdress, port);

		SocketRW sc = new SocketRW(client.getInputStream(),
				client.getOutputStream());
		Scanner scen = new Scanner(System.in);
		Robot r = new Robot();
		while (true) {
			String message = sc.recieve();
			String[] parts = message.split(",");
			int x = Integer.parseInt(parts[0]), y = Integer.parseInt(parts[1]);
			
			r.mouseMove(x, y);
		}

//		System.out.println("\nGotovo");
//		client.close();

	}

	public static void main(String[] args) {
		try {
			connectToServer();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
