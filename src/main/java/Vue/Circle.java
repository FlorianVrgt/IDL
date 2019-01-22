package Vue;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

public class Circle extends JPanel {
	@Override
	public void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		Shape circle = new Ellipse2D.Double(0, 0, getWidth(), getHeight());
		g2.draw(circle);
		this.setBorder(BorderFactory.createLineBorder(Color.black, 1));
	
	}
}
