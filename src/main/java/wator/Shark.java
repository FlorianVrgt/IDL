package wator;

import java.util.ArrayList;

import core.Agent;
import core.CaseAgent;
import core.Environement;
import core.SMA;
import particules.Carnivore;
import particules.Particules;

public class Shark extends Carnivore {

	

	public Shark(int posX, int posY, Agent[][] grille, Environement env, SMA sma, int energyToReproduce,
			int energyToDie, int energyCurrent, int energieDefault,Boolean born) {
		super(posX, posY, grille, env, sma, energyToReproduce, energyToDie, energyCurrent, energieDefault,born);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void create(int x, int y) {
		Shark s = new Shark(x, y, grille, env, sma, energyToReproduce, energyToDie, energyCurrent, energieDefault,true);
		 sma.getListeAgent().add(0,s);
		 grille[x][y]=s;


	}

}
