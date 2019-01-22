package core;

import java.util.List;
import java.util.Observable;
import java.util.Observer;

public class SMA {
	List<Agent> listeAgent;
	Agent grille[][];

	
	public SMA(List<Agent> listeAgent, Agent grille [][]) {
		super();
		this.listeAgent = listeAgent;
		this.grille= grille;
		
	}

	public void run() {
		for(Agent a: listeAgent) { // see random 
			a.decide();
		}
		
	}


}
