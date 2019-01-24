package core;

import java.util.ArrayList;
import java.util.List;

import wator.Fish;

public abstract class Agent {
	

	protected int posY;

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


	public Agent(int posX, int posY, Agent grille[][], int tailleX, int tailleY,int gestation,Environement env) {
		super();
		this.setPosX(posX);
		this.posY = posY;
	
		this.tailleX = tailleX;
		this.tailleY = tailleY;
		this.grille = grille;
		this.gestation=gestation;
		this.env=env;
	}

	/*
	 * fonction pour donner la main à l'agent change de position et de pas.
	 */
	public  void decide() {
		ArrayList<CaseAgent> caseDispo = env.caseAccesible(posX, posY);
		ArrayList<CaseAgent> canMove = new ArrayList<>();
		ArrayList<Agent> listCanEat = new ArrayList<>();
		for (CaseAgent ca : caseDispo) {
			if (env.getCase(ca)== null) {
				canMove.add(new CaseAgent(ca.getX(), ca.getY()));
			}else if(canEat(ca)) {
				listCanEat.add(env.getCase(ca));
			}

		}
		
		if(listCanEat.size()>=1) {
			System.out.println("eat");
			CaseAgent toMove = canMove.get((int) (Math.random() * canMove.size()));
			int futx = toMove.getX();
			int futy = toMove.getY();
			
			if(currentGestation>=gestation) {
				int antx= posX;
				int anty= posY;
				move(posX, posY, futx, futy);
				create(antx, anty);
				currentGestation=0;
			}else {
				move(posX, posY, futx, futy);
			}
		} else if (canMove.size() >= 1) {
			System.out.println("move");
			CaseAgent toMove = canMove.get((int) (Math.random() * canMove.size()));
			int futx = toMove.getX();
			int futy = toMove.getY();
			
			if(currentGestation>=gestation) {
				int antx= posX;
				int anty= posY;
				move(posX, posY, futx, futy);
				create(antx, anty);
			}else {
				move(posX, posY, futx, futy);
			}
			
			
		} else {
			System.out.println("case non accesible");
		}
	}


	@Override
	public String toString() {
		return "Agent [posX= " +posX+", posY=" + posY +  ", gestation=" + gestation
				+ ", currentGestation=" + currentGestation + "]";
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
		System.out.println("x:"+x+" y:"+y+"futx:"+futx+"futy: "+futy);
		grille[futx][futy]=this;
		grille[x][y]=null;
		posX=x;
		posY=y;
		currentGestation++;
	}
	
	public abstract boolean canEat(CaseAgent ca);
	
	public  abstract void create(int x, int y);
		

}
