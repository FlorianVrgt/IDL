package Vue;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;

import javax.swing.JPanel;

import core.Environement;

public class Jpan extends JPanel {
	Environement env;

	public Environement getEnv() {
		return env;
	}

	public void setEnv(Environement env) {
		this.env = env;
	}

	public Jpan(Environement env) {
		super();
		this.env = env;
	}

	@Override
	public void paintComponent(Graphics g) {
		g.clearRect(0, 0, 1500, 1500);
		int sizeX=1250/env.getSizeX();
		int sizeY=1250/env.getSizeY();
		if (env != null) {
			for (int i = 0; i < env.getSizeX(); i++) {
				for (int j = 0; j < env.getSizeY(); j++) {
					if (env.getGrille()[i][j] != null) {
						g.fillOval(i*sizeX,j*sizeY, 75, 75);
					} 

				}
			}
		}
	}
}
