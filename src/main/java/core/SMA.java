package core;

import java.util.List;
import java.util.Observable;
import java.util.Observer;

public class SMA {
	List<Agent> listeAgent;
	Agent grille[][];

	public SMA(List<Agent> listeAgent, Agent grille[][]) {
		super();
		this.listeAgent = listeAgent;
		this.grille = grille;

	}

	public void run() { // modif agent create
		int size = listeAgent.size();
		System.out.println("nbAgent" + size);

		// to del

		for (int i = 0; i < listeAgent.size(); i++) {
			Agent a = listeAgent.get(i);

			a.decide();
			

		}

	}

	public List<Agent> getListeAgent() {
		return listeAgent;
	}

	public void setListeAgent(List<Agent> listeAgent) {
		this.listeAgent = listeAgent;
	}

}
