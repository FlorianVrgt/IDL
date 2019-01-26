package core;

import java.util.ArrayList;
import java.util.List;

import wator.Fish;

public abstract class Agent {
	

	public Agent(int posY, Boolean born, Agent[][] grille, Environement env, SMA sma, int posX) {
		super();
		this.posY = posY;
		this.born = born;
		this.grille = grille;
		this.env = env;
		this.sma = sma;
		this.posX = posX;
	}

	protected int posY;
	protected Boolean born;

	protected Agent grille[][];
	protected Environement env;
	protected SMA sma;
	
	protected int posX;
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
	public  abstract void decide();
	

	protected void coverCase(ArrayList<CaseAgent> caseDispo, ArrayList<CaseAgent> canMove,
			ArrayList<Agent> listCanEat) {
		for (CaseAgent ca : caseDispo) {
			if (env.getCase(ca)== null) {
				canMove.add(new CaseAgent(ca.getX(), ca.getY()));
			}else if(canEat(ca)) {
				listCanEat.add(env.getCase(ca));
			}

		}
	}


	@Override
	public String toString() {
		return "Agent [posX= " +posX+", posY=" + posY +   "]";
	}


	public abstract boolean isMustDie();
	
	

	public void die() {
		grille[getPosX()][posY]=null;
		env.die++;
		System.out.println(sma.listeAgent.remove(this));
		
		
		
		
	}
	
	

	public int getPosX() {
		return posX;
	}

	public void setPosX(int posX) {
		this.posX = posX;
	}
	/*
	 * déplace l'agent en futx, futy [CaseAgent [x=1, y=0], CaseAgent [x=1, y=1], CaseAgent [x=1, y=2], CaseAgent [x=2, y=0], CaseAgent [x=2, y=2], CaseAgent [x=3, y=0], CaseAgent [x=3, y=1], CaseAgent [x=3, y=2]]
et actualise ces coordonées
	 */
	public void move(int x, int y, int futx, int futy) {
		//System.out.println("x:"+x+" y:"+y+"futx:"+futx+"futy: "+futy);
		grille[futx][futy]=this;
		grille[x][y]=null;
		posX=futx;
		posY=futy;
	}
	
	public abstract boolean canEat(CaseAgent ca);
	
	public  abstract void create(int x, int y);
		

}
