package core;

import java.util.ArrayList;

import SMA.SMA;
import Vue.Vue;
import hunt.Wall;

public class Torique extends Environement {

	public Torique(int sizeX, int sizeY, int nbFish, int nbShark, Vue vue,SMA sma) {
		super(sizeX, sizeY, nbFish, nbShark, vue,sma);
		// TODO Auto-generated constructor stub
	}
	
	public Torique(int sizeX, int sizeY, int nbBille, Vue vue,SMA sma) {
		super(sizeX, sizeY, nbBille, vue,sma);
		// TODO Auto-generated constructor stub
	}
	
	public Torique(int sizeX, int sizeY, int nbHunt, Vue vue,int difficulte, int nbWall,SMA sma) {
		super(sizeX, sizeY, nbHunt, vue,1,nbWall,sma);
		// TODO Auto-generated constructor stub
	}

	@Override
	public ArrayList<CaseAgent> caseAccesible(int x, int y) {
		ArrayList<CaseAgent> ca = new ArrayList<CaseAgent>();

		for (int i = x - 1; i <= x + 1; i++) {
			for (int j = y - 1; j <= y + 1; j++) {
				int cX= Math.floorMod(i, this.sizeX);
				int cY = Math.floorMod(j, this.sizeY);
				
				if(grille[cX][cY]==null || !grille[cX][cY].getClass().equals(Wall.class))
					ca.add(new CaseAgent(cX, cY));
				
			}
		}
		
			
		
		// System.out.println(ca);
		// System.out.println("nb case acces"+ca.size());
		return ca;
	}
}
