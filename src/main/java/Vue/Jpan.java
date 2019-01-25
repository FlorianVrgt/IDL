package Vue;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

import core.Environement;
import wator.*;

public class Jpan extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
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
		g.clearRect(0, 0,(int) this.getSize().getWidth(), (int)this.getSize().getHeight());
		double sizeX=this.getSize().getHeight()/env.getSizeX();
		double sizeY=this.getSize().getHeight()/env.getSizeY();
		System.out.println(sizeX + "  et sizeY " + sizeY);
		if (env != null) {
			int coorX = 0;
			int coorY = 0;
			for(int w = 0; w < env.getSizeX(); w++) {
				g.drawLine(coorX, 0, coorX, (int) this.getSize().getHeight());
				coorX += (int) sizeX;
			}
			for(int h = 0; h < env.getSizeY(); h++) {
				g.drawLine(0, coorY, (int) this.getSize().getHeight(), coorY);
				coorY += (int) sizeY;
			}
			for (int i = 0; i < env.getSizeX(); i++) {
				for (int j = 0; j < env.getSizeY(); j++) {
					if (env.getGrille()[i][j] != null) {
						if(env.getGrille()[i][j].getClass() == Fish.class) {
							g.setColor(new Color(255,0,0));
							g.fillOval(i*((int)sizeX),j*((int)sizeY), ((int)sizeX), ((int)sizeX));
						}
						else {
							g.setColor(new Color(51,51,51));
							g.fillOval(i*((int)sizeX),j*((int)sizeY), ((int)sizeX), ((int)sizeX));
						}
					} 

				}
			}
		}
	}
}
