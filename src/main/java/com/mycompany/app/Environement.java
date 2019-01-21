package com.mycompany.app;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

public class Environement extends Observable {

	private Agent grille[][];
	private int sizeX;
	private int sizeY;
	private SMA sma;
	private List<Agent> listeAgent;

	public Environement(int sizeX, int sizeY, int nbAgent, Vue vue) {
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

		for (int i = 0; i < nbAgent; i++) {
			int index = (int) (Math.random() * caseVide.size());
			System.out.println(index);
			CaseAgent caseAgent = caseVide.get(index);

			int posx = (int) (Math.random() * 3) - 1;
			int posy = (int) (Math.random() * 3) - 1;
			a = new Agent(caseAgent.getX(), caseAgent.getY(), posx, posy, grille, sizeX, sizeY);
			grille[caseAgent.getX()][caseAgent.getY()] = a;
			listeAgent.add(a);
			caseVide.remove(index);
		}
		sma = new SMA(listeAgent, grille);

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
					s += "X |";
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

}
