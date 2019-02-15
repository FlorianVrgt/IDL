package SMA;

import java.util.List;

import core.Agent;
import particules.Particules;
import wator.Fish;
import wator.Shark;

public class SequentielEquitable extends SMA{

	public SequentielEquitable(List<Agent> listeAgent, Agent[][] grille) {
		super(listeAgent, grille);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void sequence() {
		for (int i = 0; i < listeAgent.size(); i++) {
			Agent a = listeAgent.get(i);
			if((a.getClass().equals(Shark.class) || a.getClass().equals(Fish.class))){
				 Particules p = (Particules) a; 
					if(!p.isDead()) {
						p.decide();
					}else {
						listeAgent.remove(p);
					}
				}else {
					a.decide();
				}
			

		}
		
	}

}
