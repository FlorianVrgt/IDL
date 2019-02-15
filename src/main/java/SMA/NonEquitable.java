package SMA;

import java.util.List;

import core.Agent;
import particules.Particules;
import wator.Fish;
import wator.Shark;

public class NonEquitable extends SMA{

	public NonEquitable(List<Agent> listeAgent, Agent[][] grille) {
		super(listeAgent, grille);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void sequence() {
		for (int i = 0; i < listeAgent.size(); i++) {
			Agent a = listeAgent.get((int) (Math.random()*listeAgent.size()));
			
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
