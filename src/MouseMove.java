import java.awt.AWTException;
import java.awt.Robot;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JPanel;


public class MouseMove {
	public static void main(String[] args) throws AWTException {
		JFrame window = new JFrame("Motion log");
		JPanel content = new JPanel();
		
		window.add(content);
		window.setSize(500, 500);
		window.setVisible(true);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Scanner in = new Scanner(System.in);
		Robot r = new Robot();
		while(true){
			System.out.println("Enter x, y");
			int x = in.nextInt();
			int y = in.nextInt();
			r.mouseMove(x, y);
		}
	}
}
