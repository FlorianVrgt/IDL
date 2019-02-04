package hunt;

import SMA.SMA;
import core.Agent;
import core.Environement;

public class Avatar extends Agent{
int pasX, pasY; 

	public Avatar(int posX, int posY, Agent[][] grille, Environement env, SMA sma, Boolean born) {
		super(posX, posY, grille, env, sma, born);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void decide() {
		
	int i = posX+pasX;
	int j= posY+pasY;
		if (i >= 0 && j >= 0 && i < env.getSizeX() && j < env.getSizeY())
		move(posX, posY, pasX, pasY);
		
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
