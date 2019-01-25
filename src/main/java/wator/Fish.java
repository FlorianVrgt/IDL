package wator;

import java.util.ArrayList;

import core.Agent;
import core.CaseAgent;
import core.Environement;
import core.SMA;
import particules.Herbivore;
import particules.Particules;

public class Fish extends Herbivore {


	

	public Fish(int posX, int posY, Agent[][] grille, Environement env, SMA sma, int currentGestation, int gestation, Boolean born) {
		super(posX, posY, grille, env, sma, currentGestation, gestation, born);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void create(int x, int y) {
		
		grille[x][y]=new Fish(x, y, grille, env, sma, 0, gestation,true);
		 sma.getListeAgent().add(0,grille[x][y]);
		currentGestation=0;
		//System.out.println("fish create");
		
	}

	@Override
	public boolean isMustDie() {
		return false;
	}

	@Override
	public boolean canEat(CaseAgent ca) {
		
		return false;
	}

}
