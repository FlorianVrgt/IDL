package wator;

import java.util.ArrayList;

import core.Agent;
import core.CaseAgent;
import core.Environement;
import particules.Particules;

public class Shark extends Particules {



	public Shark(int posX, int posY, Agent[][] grille, int tailleX, int tailleY, int gestation,
			Environement env) {
		super(posX, posY, grille, tailleX, tailleY, gestation, env);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void decide() {
		super.decide();
			
		}

	@Override
	public boolean isMustDie() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void create(int x, int y) {
		grille[x][y]= new Shark(x, y, grille, tailleX, tailleY, gestation,env);
	}

	@Override
	public boolean canEat(CaseAgent ca) {
		return env.getCase(ca).getClass().equals(Fish.class); 
	}

}
