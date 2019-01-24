package core;

import java.util.ArrayList;

import Vue.Vue;

public class NonTorique extends Environement{

	public NonTorique(int sizeX, int sizeY, int nbAgent, Vue vue) {
		super(sizeX, sizeY, nbAgent, vue);
		// TODO Auto-generated constructor stub
	}

	@Override
	public ArrayList<CaseAgent> caseAccesible(int x, int y) {
		ArrayList<CaseAgent> ca = new ArrayList<CaseAgent>();
		for (int i = x-1; i <x + 1 ; i++) {
			for (int j = y-1; j < y+1; j++) {
				if(i>=0 && j>=0 && i<sizeX && y<sizeY ) {
					ca.add(new CaseAgent(i, j));
				}
			}
		}
		return ca;
	}

}
