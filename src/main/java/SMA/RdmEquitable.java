package SMA;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import core.Agent;

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
					
			if(!a.isDead()) {
				a.decide();
			}else {
				listeAgent.remove(a);
			}
			

		}
		
	}

}
