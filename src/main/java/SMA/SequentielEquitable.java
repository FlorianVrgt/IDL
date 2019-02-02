package SMA;

import java.util.List;

import core.Agent;

public class SequentielEquitable extends SMA{

	public SequentielEquitable(List<Agent> listeAgent, Agent[][] grille) {
		super(listeAgent, grille);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void sequence() {
		for (int i = 0; i < listeAgent.size(); i++) {
			Agent a = listeAgent.get(i);
			if(!a.isDead()) {
				a.decide();
			}else {
				listeAgent.remove(a);
			}
			

		}
		
	}

}
