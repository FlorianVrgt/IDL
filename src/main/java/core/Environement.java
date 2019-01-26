package core;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Random;

import Vue.Vue;
import wator.Fish;
import wator.Shark;

public abstract class Environement extends Observable {

	protected Agent grille[][];
	protected int sizeX;
	protected int sizeY;
	protected SMA sma;
	public int die;
	protected List<Agent> listeAgent;

	public Environement(int sizeX, int sizeY, int nbAgent, Vue vue) {
		die=0;
		ArrayList<CaseAgent> caseVide = new ArrayList<CaseAgent>();
		listeAgent = new ArrayList<Agent>();
		grille = new Agent[sizeX][sizeY];
		Agent a = null;
		this.sizeX = sizeX;
		this.sizeY = sizeY;

		this.addObserver(vue);
		if (nbAgent >= sizeX * sizeY) {
			System.out.println("Erreur, trop d'agent");
			System.exit(-1);
		}

		for (int i = 0; i < sizeX; i++) {
			for (int j = 0; j < sizeY; j++) {
				caseVide.add(new CaseAgent(i, j));
			}
		}
		sma = new SMA(listeAgent, grille);
		for (int i = 0; i < nbAgent; i++) {
			int index = (int) (Math.random() * caseVide.size());
			System.out.println(index);
			CaseAgent caseAgent = caseVide.get(index);

			if((Math.random()*101)<50 ) {
			a = new Fish(caseAgent.getX(), caseAgent.getY(), grille, this,sma,0,3,false);
			}else {
				a= new Shark(caseAgent.getX(), caseAgent.getY(), grille,this,sma,4,0,2,2,false);
			}
			grille[caseAgent.getX()][caseAgent.getY()] = a;
			listeAgent.add(a);
			caseVide.remove(index);
		}
		

	}

	public Agent[][] getGrille() {
		return grille;
	}

	public void setGrille(Agent[][] grille) {
		this.grille = grille;
	}

	public int getSizeX() {
		return sizeX;
	}

	public void setSizeX(int sizeX) {
		this.sizeX = sizeX;
	}

	public int getSizeY() {
		return sizeY;
	}

	public void setSizeY(int sizeY) {
		this.sizeY = sizeY;
	}

	public List<Agent> getListeAgent() {
		return listeAgent;
	}

	public void setListeAgent(List<Agent> listeAgent) {
		this.listeAgent = listeAgent;
	}

	public SMA getSma() {
		return sma;
	}

	public void setSma(SMA sma) {
		this.sma = sma;
	}

	public String toString() {
		String s = "";
		for (int i = 0; i < sizeX; i++) {
			for (int j = 0; j < sizeY; j++) {
				if (grille[i][j] != null) {
					if(grille[i][j].getClass().equals(Fish.class)) {
						s += "F |";
						
					}else {
						s +="R |";
					}
				} else {
					s += "O |";
				}

			}
			s += "\n";
		}
		return s;
	}

	public void step() {

		sma.run();
		setChanged();
		notifyObservers();
	}
	public Agent getCase(CaseAgent ca) {
		return grille[ca.getX()][ca.getY()];
	}
	
	public abstract ArrayList<CaseAgent> caseAccesible(int x, int y);

	
	

}
