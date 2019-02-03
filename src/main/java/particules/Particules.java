package particules;

import java.util.ArrayList;

import SMA.SMA;
import core.Agent;
import core.CaseAgent;
import core.Environement;

public abstract class Particules extends Agent {

	public Particules(int posX, int posY, Agent[][] grille, Environement env, SMA sma, Boolean born) {
		super(posX, posY, grille, env, sma, born);
		// TODO Auto-generated constructor stub
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

	public abstract boolean isMustDie();

	public void die() {
		grille[posX][posY] = null;
		env.die++;
		this.dead = true;
		sma.getListeAgent().remove(this);

	}
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

}
