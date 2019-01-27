package core;

import java.util.ArrayList;

import Vue.Vue;

public class Torique extends Environement {

	public Torique(int sizeX, int sizeY, int nbAgent, Vue vue) {
		super(sizeX, sizeY, nbAgent, vue);
		// TODO Auto-generated constructor stub
	}

	@Override
	public ArrayList<CaseAgent> caseAccesible(int x, int y) {
		ArrayList<CaseAgent> ca = new ArrayList<CaseAgent>();

		for (int i = x - 1; i <= x + 1; i++) {
			for (int j = y - 1; j <= y + 1; j++) {
				
					ca.add(new CaseAgent(i%this.sizeX, j%this.sizeY));

				
			}
		}
		// System.out.println(ca);
		// System.out.println("nb case acces"+ca.size());
		return ca;
	}
}
