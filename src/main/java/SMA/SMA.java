package SMA;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

import core.Agent;

public abstract class  SMA {
	List<Agent> listeAgent;
	List<Agent> agentToAdd;
	public List<Agent> getAgentToAdd() {
		return agentToAdd;
	}

	public void setAgentToAdd(List<Agent> agentToAdd) {
		this.agentToAdd = agentToAdd;
	}

	Agent grille[][];

	public SMA(List<Agent> listeAgent, Agent grille[][]) {
		super();
		this.listeAgent = listeAgent;
		this.grille = grille;
		this.agentToAdd= new ArrayList<Agent>();

	}

	public void run() { // modif agent create
		for (Agent agent : agentToAdd) {
			listeAgent.add(agent);
		}
		agentToAdd.clear();
		int size = listeAgent.size();
		System.out.println("nbAgent" + size);
		
		// to del
		

		sequence();

	}

	protected abstract void sequence();
		

	public List<Agent> getListeAgent() {
		return listeAgent;
	}

	public void setListeAgent(List<Agent> listeAgent) {
		this.listeAgent = listeAgent;
	}

}
