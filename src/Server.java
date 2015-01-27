import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Server {
	// nesto kao adresa ili otvor gdje cekamo konekciju,
	// rade od 0 do cc.65000,
	// koristiti portove iznad 1500
	public static final int port = 1728;
	public static String position = "";

	/**
	 * @throws IOException
	 * 
	 */

	public static void startServer() {
		try {
			Scanner scen = new Scanner(System.in);
			// socket koji ceka da se neko na njega spoji
			ServerSocket server = new ServerSocket(port);
			

			
			while (true) {

				System.out.println("waiting");
				Socket client = server.accept();
				SocketRW sc = new SocketRW(client.getInputStream(),
						client.getOutputStream());
				while(true){
					
					
					String userInput = position;

					sc.send(userInput);
					if(userInput.equals("quit"))
						break;
				}
				
				

				client.close();
				// accept vraca new Socket
				// kada upisemo accept nista ispod ove
				// linije nece se izvrsiti dok se ne desi konekcija

				System.out.println("Gotovo");

			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		addGraphics();
		startServer();
	}

	public static void addGraphics(){
		JFrame window = new JFrame("Motion log");
		JPanel content = new JPanel();
		
		content.addMouseMotionListener(new MouseListener());
		GraphicsEnvironment ge = 
	            GraphicsEnvironment.getLocalGraphicsEnvironment();
	        GraphicsDevice gd = ge.getDefaultScreenDevice();

	        //If translucent windows aren't supported, exit.
	        if (!gd.isWindowTranslucencySupported(GraphicsDevice.WindowTranslucency.TRANSLUCENT)) {
	            System.err.println(
	                "Translucency is not supported");
	                System.exit(0);
	        }
		window.add(content);
		window.setExtendedState(JFrame.MAXIMIZED_BOTH);
		window.setUndecorated(true);
		window.setOpacity(0.2f);
		window.setVisible(true);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	private static class MouseListener extends MouseAdapter {
		public void mouseMoved(MouseEvent e) {
		       position = e.getX() + ","+e.getY();
		    }
	}

}
