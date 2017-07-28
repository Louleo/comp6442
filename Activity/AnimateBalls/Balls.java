import java.awt.Graphics2D;
import java.util.ArrayList;


public class Balls {
	
	double w,h;
	
	ArrayList<Ball> lst;
	
	int step = 0;
	
	public Balls(double w, double h) {
		lst = new ArrayList<Ball>();
		this.w = w;
		this.h = h;
	}

	public void step(double d) {
		if (step % 10 == 0) {
			lst.add(new Ball(100.0,6.0,1.5,2.3));
			lst.add(new Ball(100.0 + Ball.radius*4,6.0,1.5,2.3));
			lst.add(new Ball(100.0 + Ball.radius*8,6.0,1.5,2.3));
		}
		if (step % 10 == 5) {
			lst.add(new Ball(100.0 + Ball.radius*2,6.0,1.5,2.3));
			lst.add(new Ball(100.0 + Ball.radius*6,6.0,1.5,2.3));
			lst.add(new Ball(100.0 + Ball.radius*10,6.0,1.5,2.3));
		}
		step++;
		
		
		for (Ball b : lst) {
			b.step1(w,h);
		}
		for (int i = 0;i< lst.size();i++) {
			for (int j = i+1;j< lst.size();j++) {
				Ball.interact(lst.get(i),lst.get(j));
			}
		}
		for (Ball b : lst) {
			b.step2(w,h);
		}
	}

	public void draw(Graphics2D g2) {
		for (Ball b : lst) {
			b.draw(g2);
		}
	}

}
