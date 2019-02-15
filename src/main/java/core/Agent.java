package core;

import java.util.ArrayList;

import SMA.SMA;
import hunt.Avatar;

public abstract class Agent {

	public Agent(int posX, int posY, Agent[][] grille, Environement env, SMA sma, Boolean born) {
		super();
		this.posY = posY;
		this.born = born;
		this.grille = grille;
		this.env = env;
		this.sma = sma;
		this.posX = posX;
		
	}
	
	protected int posX;
	protected int posY;
	protected Boolean born;
	protected boolean dead;
	protected Agent grille[][];
	protected Environement env;
	protected SMA sma;
	

	public SMA getSma() {
		return sma;
	}

	public void setSma(SMA sma) {
		this.sma = sma;
	}

	

	public int getPosY() {
		return posY;
	}

	public void setPosY(int posY) {
		this.posY = posY;
	}

	public Agent[][] getGrille() {
		return grille;
	}

	public void setGrille(Agent[][] grille) {
		this.grille = grille;
	}

	/*
	 * fonction pour donner la main à l'agent change de position et de pas.
	 */
	public abstract void decide();

	


	@Override
	public String toString() {
		return "Agent [posX= " + posX + ", posY=" + posY + "]";
	}

	

	public int getPosX() {
		return posX;
	}

	public void setPosX(int posX) {
		this.posX = posX;
	}


	

	public void move(int x, int y, int futx, int futy) {
		if (this != grille[posX][posY]) {
			System.out.println("Erreur");
		}
		// System.out.println("x:"+x+" y:"+y+"futx:"+futx+"futy: "+futy);
		grille[futx][futy] = this;
		grille[x][y] = null;
		posX = futx;
		posY = futy;
		if (this != grille[posX][posY]) {
			System.out.println("Erreur move");
		}
	}
	

	
	public CaseAgent goTo(Avatar avatar) {
		
		 ArrayList<CaseAgent> listAgent= env.caseAccesible(posX,posY);
		 CaseAgent result=null;
		 int plusPettit=Integer.MAX_VALUE;
		 for (CaseAgent ca: listAgent) {
			if(avatar.getTabDijsktra()[ca.getX()][ca.getY()]<plusPettit) {
				plusPettit= avatar.getTabDijsktra()[ca.getX()][ca.getY()];
				result =ca;
			}
		}
		 return result;

	}


}
