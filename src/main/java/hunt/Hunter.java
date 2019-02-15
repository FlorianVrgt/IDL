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
	Avatar avatar;
	

	public Hunter(int posX, int posY, Agent[][] grille, Environement env, SMA sma, Boolean born,Avatar avatar) {
		super(posX, posY, grille, env, sma, born);
		this.avatar =avatar;
	}

	@Override
	public void decide() {
		avatar.dijstra(new CaseAgent(avatar.getPosX(), avatar.getPosY()), 1);
		//avatar.afficherTab();
		CaseAgent ca = goTo(avatar);
		if(env.getCase(ca)!=null && env.getCase(ca).getClass().equals(Avatar.class))
			System.out.println("Loooose");
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

	

}
