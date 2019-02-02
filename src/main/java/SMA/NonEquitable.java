package SMA;

import java.util.List;

import core.Agent;

public class NonEquitable extends SMA{

	public NonEquitable(List<Agent> listeAgent, Agent[][] grille) {
		super(listeAgent, grille);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void sequence() {
		for (int i = 0; i < listeAgent.size(); i++) {
			Agent a = listeAgent.get((int) (Math.random()*listeAgent.size()));
			if(!a.isDead()) {
				a.decide();
			}else {
				listeAgent.remove(a);
			}
			

		}
		
	}

}
