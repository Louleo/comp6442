import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;

import javax.swing.ImageIcon;


public class Ball {
    double x,y, vx, vy, sx, sy;

    static final ImageIcon ember = new ImageIcon(AnimateBalls.class.getResource("ember.png"));
    static final Integer emberWidth = ember.getIconWidth();
    static final Integer emberHeight = ember.getIconHeight();

    static final double radius = 7.0;
    
	public Ball(double x, double y, double vx, double vy) {
		super();
		this.x = x;
		this.y = y;
		this.vx = vx;
		this.vy = vy;
	}

	public void draw(Graphics2D g2) {
		g2.fill(new Ellipse2D.Double(x-radius, y-radius, 2.0*radius, 2.0*radius));
		//g2.drawImage(ember.getImage(),(int) x, (int) y, null);
	}

	public void step1(double w, double h) {
		x += vx;
		y += vy;
		
		sx = 0.0;
		sy = 0.1;
		
		double yb = (h-radius -40.0);
		if (y>yb ) {
			
			if (vy > 0.0) sy +=  - 1.8 * vy;
			y = yb;
			
		} 
		
		if (x < radius && vx < 0.0) {
			x = radius;
			if (vx < 0.0) sx +=  - 1.8 * vx;
			
		} else if (x > w - radius ) {
			x = w - radius ;
			if (vx > 0.0) sx +=  - 1.8 * vx;
			
		}
	
	}

	public static void interact(Ball b1, Ball b2) {
		double dx = b2.x - b1.x;
		double dy = b2.y - b1.y;
		double d2 = dx*dx + dy*dy;
		if (d2 < radius*radius*4) {
			double d = Math.sqrt(d2);
			double ndx = dx / d;
			double ndy = dy / d;
			
			double pl1 = ndx*b1.vx + ndy*b1.vy;
			double pl1x = pl1 * ndx;
			double pl1y = pl1 * ndy;
			
			double pl2 = ndx*b2.vx + ndy*b2.vy;
			double pl2x = pl2 * ndx;
			double pl2y = pl2 * ndy;
			
			if (pl1 - pl2 > 0.0   ) {
			
			double damp1 = 0.9;
			double damp2 = 1.0;
			b2.vx += damp1 * pl1x - damp2 * pl2x;
			b2.vy += damp1 * pl1y - damp2 * pl2y;
			b1.vx += damp2 * pl2x - damp1 * pl1x;
			b1.vy += damp2 * pl2y - damp1 * pl1y;
			}
			double shift = 0.07*((radius*2.0 - d)/2.0)*((radius*2.0 - d)/2.0);
			
			b1.sx -= shift * ndx;
			b1.sy -= shift * ndy;
			b2.sx += shift * ndx;
			b2.sy += shift * ndy;
		}
		
	}
    
	public void step2(double w, double h) {
		vx += sx - 0.005*vx;
		vy += sy - 0.005*vy;
	}
	
	
}


