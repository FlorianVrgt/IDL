package SMA;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import core.Agent;
import particules.Particules;
import wator.Fish;
import wator.Shark;

public class RdmEquitable extends SMA{

	public RdmEquitable(List<Agent> listeAgent, Agent[][] grille) {
		super(listeAgent, grille);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void sequence() {
		
		List<Agent> cplist = new ArrayList<Agent>(listeAgent);
		int size= cplist.size();
				for (int i = 0; i < size; i++) {
					int j=(int) Math.random()*cplist.size();
					Agent a = cplist.get(j);
					cplist.remove(a);
					
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
