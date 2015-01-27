import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.Color;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Robot;

public class MouseLog {
	
	public static void main(String[] args){
		
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
		       System.out.println("Mouse moved x:" + e.getX() + " y:" + e.getY());
		    }
	}

}
