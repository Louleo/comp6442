import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

public class AnimateBalls implements Runnable {

	/**
	 * AnimateBalls - a simple ball animation program. Eric McCreath 2015 -
	 */

	JFrame jframe;
	static GraphicsDevice device = GraphicsEnvironment
	        .getLocalGraphicsEnvironment().getScreenDevices()[0];

	public AnimateBalls() {
		SwingUtilities.invokeLater(this);
	}

	public static void main(String[] args) {
		new AnimateBalls();
	}

	public void run() {
		jframe = new JFrame("AnimateBalls");
		jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//jframe.setUndecorated(true);

		//device.setFullScreenWindow(jframe);	
		//int w = device.getDisplayMode().getWidth();
		//int h = device.getDisplayMode().getHeight();
		int w = 600;
		int h = 500;
		jframe.getContentPane().add(new AnimateBallsJComp(w,h));

		jframe.setVisible(true);
		jframe.pack();
		
		Timer timer = new Timer(1000 * 30,new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				System.exit(0);
			}
		});
		timer.start();
	}
}
