package wator;

import core.Agent;
import core.CaseAgent;
import core.Environement;
import core.SMA;
import particules.Particules;

public class Fish extends Particules {



	public Fish(int posX, int posY,  Agent[][] grille, int gestation,
			Environement env,SMA sma) {
		super(posX, posY, grille,  gestation, env,sma);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void decide() {
		super.decide();
	

	}

	@Override
	public void create(int x, int y) {
		
		grille[x][y]=new Fish(x, y, grille, gestation,env,sma);
		 sma.getListeAgent().add(0,grille[x][y]);
		currentGestation=0;
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
