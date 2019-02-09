package hunt;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import SMA.SMA;
import core.Agent;
import core.CaseAgent;
import core.Environement;

public class Hunter extends Agent {
	int pasX, pasY;

	

	public Hunter(int posX, int posY, Agent[][] grille, Environement env, SMA sma, Boolean born) {
		super(posX, posY, grille, env, sma, born);
	}

	@Override
	public void decide() {
		CaseAgent ca = goTo();
		
		move(posX, posY, ca.getX(), ca.getY());
		
	}

	@Override
	public boolean isDead() {
		// TODO Auto-generated method stub
		return false;
	}

	



	@Override
	public void die() {
		// TODO Auto-generated method stub

	}

	@Override
	public Boolean getBorn() {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
