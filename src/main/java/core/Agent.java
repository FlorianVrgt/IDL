package core;

import java.util.List;

public abstract class Agent {
	

	protected int posY;
	protected int pasX;
	protected int pasY;
	protected int tailleX;
	protected int tailleY;
	protected int gestation;
	protected int currentGestation;
	protected Agent grille[][];
	protected Environement env;
	
	protected int posX;
	public int getPosY() {
		return posY;
	}

	public void setPosY(int posY) {
		this.posY = posY;
	}

	public int getPasX() {
		return pasX;
	}

	public void setPasX(int pasX) {
		this.pasX = pasX;
	}

	public int getPasY() {
		return pasY;
	}

	public void setPasY(int pasY) {
		this.pasY = pasY;
	}

	public int getTailleX() {
		return tailleX;
	}

	public void setTailleX(int tailleX) {
		this.tailleX = tailleX;
	}

	public int getTailleY() {
		return tailleY;
	}

	public void setTailleY(int tailleY) {
		this.tailleY = tailleY;
	}

	public int getGestation() {
		return gestation;
	}

	public void setGestation(int gestation) {
		this.gestation = gestation;
	}

	public int getCurrentGestation() {
		return currentGestation;
	}

	public void setCurrentGestation(int currentGestation) {
		this.currentGestation = currentGestation;
	}

	public Agent[][] getGrille() {
		return grille;
	}

	public void setGrille(Agent[][] grille) {
		this.grille = grille;
	}


	public Agent(int posX, int posY, int pasX, int pasY, Agent grille[][], int tailleX, int tailleY,int gestation,Environement env) {
		super();
		this.setPosX(posX);
		this.posY = posY;
		this.pasX = pasX;
		this.pasY = pasY;
		this.tailleX = tailleX;
		this.tailleY = tailleY;
		this.grille = grille;
		this.gestation=gestation;
		this.env=env;
	}

	/*
	 * fonction pour donner la main à l'agent change de position et de pas.
	 */
	public abstract void decide();

	@Override
	public String toString() {
		return "Agent [posX=" + getPosX() + ", posY=" + posY + ", pasX=" + pasX + ", pasY=" + pasY + ", tailleX=" + tailleX
				+ "]";
	}

	public void inv() {
		pasX *= -1;
		pasY *= -1;
	}
	
	public abstract boolean isMustDie();
	
	public void die() {
		grille[getPosX()][posY]=null;
		
		
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
		grille[futx][futy]=this;
		grille[x][y]=null;
		posX=x;
		posY=y;
	}
		

}
