package core;

import java.util.ArrayList;
import java.util.List;

import SMA.SMA;
import wator.Fish;

public abstract class Agent {

	public Agent(int posX, int posY, Agent[][] grille, Environement env, SMA sma, Boolean born) {
		super();
		this.posY = posY;
		this.born = born;
		this.grille = grille;
		this.env = env;
		this.sma = sma;
		this.posX = posX;
		this.tabDijsktra= new int[env.getSizeX()][env.getSizeY()];
	}
	
	protected int posX;
	protected int posY;
	protected Boolean born;
	protected boolean dead;
	protected Agent grille[][];
	protected Environement env;
	protected SMA sma;
	protected int[][] tabDijsktra;

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

	public abstract boolean isDead();

	public abstract void die();

	public abstract Boolean getBorn();

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
	
	protected void dijstra(CaseAgent ca, int numb) {
		
		ArrayList<CaseAgent> listAgent ;
		if (tabDijsktra[ca.getX()][ca.getY()] == 0) {
			listAgent= env.caseAccesible(ca.getX(), ca.getY());
			// case jamais parcouru
			tabDijsktra[ca.getX()][ca.getY()] = numb;
			for (CaseAgent caseAgent : listAgent) {
				afficherTab();
				dijstra(caseAgent, numb + 1);
			
			}

		} else if (tabDijsktra[ca.getX()][ca.getY()] > numb) {
			tabDijsktra[ca.getX()][ca.getY()]=numb;
			// meilleur chemin
			listAgent= env.caseAccesible(ca.getX(), ca.getY());
			for (CaseAgent caseAgent : listAgent) {
				dijstra(caseAgent, numb + 1);
			}
		}
		
	}
	public void afficherTab() {
		for (int i = 0; i < env.getSizeX(); i++) {
			for (int j = 0; j < env.getSizeY(); j++) {
				System.out.print(tabDijsktra[i][j]+" |");
			}
			System.out.print("\n");
		}
		System.out.println();
	}
	
	public CaseAgent goTo() {
		
		 ArrayList<CaseAgent> listAgent= env.caseAccesible(posX,posY);
		 CaseAgent result=null;
		 int plusPettit=Integer.MAX_VALUE;
		 for (CaseAgent ca: listAgent) {
			if(tabDijsktra[ca.getX()][ca.getY()]<plusPettit) {
				plusPettit= tabDijsktra[ca.getX()][ca.getY()];
				result =ca;
			}
		}
		 return result;

	}


}
