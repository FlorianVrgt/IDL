package Vue;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

import core.Environement;
import hunt.Avatar;
import hunt.Hunter;
import hunt.Wall;
import particules.Bille;
import particules.Particules;
import wator.*;

public class Jpan extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Environement env;
	Boolean grid;

	public Environement getEnv() {
		return env;
	}

	public void setEnv(Environement env) {
		this.env = env;
	}

	public Jpan(Environement env, Boolean grid) {
		super();
		this.env = env;
		this.grid = grid;
	}

	@Override
	public void paintComponent(Graphics g) {
		g.clearRect(0, 0,(int) this.getSize().getWidth(), (int)this.getSize().getHeight());
		if (env != null) {
			double sizeX=this.getSize().getWidth()/env.getSizeX();
			double sizeY=this.getSize().getHeight()/env.getSizeY();
			int coorX = 0;
			int coorY = 0;
			if(this.grid) {
				for(int w = 0; w < env.getSizeX(); w++) {
					g.drawLine(coorX, 0, coorX, env.getSizeX()* (int)sizeY);
					coorX += (int) sizeX;
				}
				for(int h = 0; h < env.getSizeY(); h++) {
					g.drawLine(0, coorY, env.getSizeY()*(int)sizeX, coorY);
					coorY += (int) sizeY;
				}
			}
			for (int i = 0; i < env.getSizeX(); i++) {
				for (int j = 0; j < env.getSizeY(); j++) {
					if (env.getGrille()[i][j] != null) {
						if(env.getGrille()[i][j].getClass() == Bille.class) {
							g.setColor(new Color(0,0,0));
							g.fillOval(i*((int)sizeX),j*((int)sizeY), ((int)sizeX), ((int)sizeY));
						}
						if(env.getGrille()[i][j].getClass() == Hunter.class) {
							g.setColor(new Color(255,0,0));
							g.fillOval(i*((int)sizeX),j*((int)sizeY), ((int)sizeX), ((int)sizeY));
						}
						if(env.getGrille()[i][j].getClass() == Avatar.class) {
							g.setColor(new Color(0,0,0));
							g.fillOval(i*((int)sizeX),j*((int)sizeY), ((int)sizeX), ((int)sizeY));
						}
						if(env.getGrille()[i][j].getClass() == Wall.class) {
							g.setColor(new Color(172,172,172));
							g.fillOval(i*((int)sizeX),j*((int)sizeY), ((int)sizeX), ((int)sizeY));
						}
						if(env.getGrille()[i][j].getClass() == Fish.class) {
							Particules p = (Particules) env.getGrille()[i][j];
							if(p.getBorn()) {
								g.setColor(new Color(255,255,0));
							}
							else {
								g.setColor(new Color(0,255,0));
							}
							g.fillOval(i*((int)sizeX),j*((int)sizeY), ((int)sizeX), ((int)sizeY));
						}
						if(env.getGrille()[i][j].getClass() == Shark.class) {
							Particules p = (Particules) env.getGrille()[i][j];
							if(p.getBorn()) {
								g.setColor(new Color(255,50,250));
							}
							else {
								g.setColor(new Color(255,0,0));
							}
							g.fillOval(i*((int)sizeX),j*((int)sizeY), ((int)sizeX), ((int)sizeY));
						}
					} 

				}
			}
		}
	}
}
