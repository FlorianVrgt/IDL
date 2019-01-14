package com.mycompany.app;

import java.util.List;

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
