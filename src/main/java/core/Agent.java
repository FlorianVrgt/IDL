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

	protected void coverCase(ArrayList<CaseAgent> caseDispo, ArrayList<CaseAgent> canMove,
			ArrayList<CaseAgent> listCanEat) {
		for (CaseAgent ca : caseDispo) {
			if (env.getCase(ca) == null) {
				canMove.add(new CaseAgent(ca.getX(), ca.getY()));
			} else if (canEat(ca)) {
				listCanEat.add(new CaseAgent(ca.getX(), ca.getY()));
			}

		}
	}

	public Boolean getBorn() {
		return born;
	}

	public void setBorn(Boolean born) {
		this.born = born;
	}

	public boolean isDead() {
		return dead;
	}

	public void setDead(boolean dead) {
		this.dead = dead;
	}

	@Override
	public String toString() {
		return "Agent [posX= " + posX + ", posY=" + posY + "]";
	}

	public abstract boolean isMustDie();

	public void die() {
		grille[posX][posY] = null;
		env.die++;
		this.dead=true;
		sma.getListeAgent().remove(this);

	}

	public int getPosX() {
		return posX;
	}

	public void setPosX(int posX) {
		this.posX = posX;
	}

	/*
	 * déplace l'agent en futx, futy et actualise ces coordonées
	 */
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

	public abstract boolean canEat(CaseAgent ca);

	public abstract void create(int x, int y);

}
