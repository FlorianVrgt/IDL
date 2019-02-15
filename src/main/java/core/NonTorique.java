package core;

import java.util.ArrayList;

import SMA.SMA;
import Vue.Vue;
import hunt.Wall;

public class NonTorique extends Environement {

	public NonTorique(int sizeX, int sizeY, int nbFish, int nbShark, Vue vue,SMA sma) {
		super(sizeX, sizeY, nbFish, nbShark, vue,sma);
		// TODO Auto-generated constructor stub
	}
	
	public NonTorique(int sizeX, int sizeY, int nbBille, Vue vue,SMA sma) {
		super(sizeX, sizeY, nbBille, vue,sma);
		// TODO Auto-generated constructor stub
	}

	public NonTorique(int sizeX, int sizeY, int nbHunt, Vue vue,int difficulte, int nbWall,SMA sma) {
		super(sizeX, sizeY, nbHunt, vue,1,nbWall,sma);
		// TODO Auto-generated constructor stub
	}
	@Override
	public ArrayList<CaseAgent> caseAccesible(int x, int y) {
		ArrayList<CaseAgent> ca = new ArrayList<CaseAgent>();
		for (int i = x - 1; i <= x + 1; i++) {
			for (int j = y - 1; j <= y + 1; j++) {
				if (i >= 0 && j >= 0 && i < sizeX && j < sizeY && (x != i || y != j)) {
					if(grille[i][j]==null || !grille[i][j].getClass().equals(Wall.class))
					ca.add(new CaseAgent(i, j));

				}
			}
		}
		// System.out.println(ca);
		// System.out.println("nb case acces"+ca.size());
		return ca;
	}

}
