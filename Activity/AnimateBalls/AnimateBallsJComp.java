import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComponent;
import javax.swing.Timer;


public class AnimateBallsJComp extends JComponent implements ActionListener {
    int width, height;
	
    Timer timer;
    Balls balls;
    int steptime = 1000/30; // in ms
    
    double currenttime;
    
    
    
	public AnimateBallsJComp(int w, int h) {
		width = w;
		height = h;
		balls = new Balls(w,h);
		timer = new Timer(steptime,this);
		timer.start();
		currenttime = 0.0;
		this.setPreferredSize(new Dimension(w,h));
	}
	
	protected void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		g2.setColor(Color.white);
		g2.fillRect(0, 0, width, height);
		g2.setColor(Color.blue);
		balls.draw(g2);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		balls.step(steptime / 1000.0);
		currenttime += steptime / 1000.0;
		repaint();
	}
	

}
