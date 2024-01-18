package lab6;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class Ball extends Thread {
	private JPanel panel;
	private float x, y;
	private float dx, dy;
	private int size;
	private Color color = Color.BLUE;
	
	public Ball(JPanel panel, float x, float y, float dx, float dy, int size) {
		super();
		this.panel = panel;
		this.x = x;
		this.y = y;
		this.dx = dx;
		this.dy = dy;
		this.size = size;
	}
	
	public void setColor(Color color) {
		this.color = color;
	}
	
	@Override
	public void run() {
		Graphics gr = panel.getGraphics();
		while (true) {
			gr.setColor(this.color);
			gr.fillRoundRect((int)x, (int)y, size, size, 5, 5);
			
			try {
				Thread.sleep(25);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			gr.setColor(panel.getBackground());
			gr.fillRoundRect((int)x, (int)y, size, size, 5, 5);
			
			if ((int)x > (panel.getWidth() - size) || (int)x < size) dx = -dx;
			if ((int)y > (panel.getHeight() - size) || (int)y < size) dy = -dy;
			
			x += dx;
			y += dy;
		}
	}
}