package wator;

import java.util.ArrayList;
import java.util.List;

import core.Agent;
import core.CaseAgent;
import core.Environement;
import particules.Particules;

public class Fish extends Particules {



	public Fish(int posX, int posY,  Agent[][] grille, int tailleX, int tailleY, int gestation,
			Environement env) {
		super(posX, posY, grille, tailleX, tailleY, gestation, env);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void decide() {
		super.decide();
	

	}

	@Override
	public void create(int x, int y) {
	
		grille[x][y]=new Fish(x, y, grille, tailleX, tailleY, gestation,env);
		System.out.println("fish create");
		
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
