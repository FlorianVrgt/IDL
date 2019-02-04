package hunt;

import java.util.ArrayList;
import java.util.List;

import SMA.SMA;
import core.Agent;
import core.CaseAgent;
import core.Environement;
import main.Dijkstra;
import main.Graph;
import main.Node;

public class Hunter extends Agent{
	int pasX, pasY; 

	public Hunter(int posX, int posY, Agent[][] grille, Environement env, SMA sma, Boolean born) {
		super(posX, posY, grille, env, sma, born);
		List<CaseAgent> caseAccesible = new ArrayList<CaseAgent>();
		Graph g = new Graph();
		for (int i = 0; i < env.getSizeX(); i++) {
			for (int j = 0; j < env.getSizeY(); j++) {
				caseAccesible= env.caseAccesible(i, j);
				 Node n = new Node(String.valueOf(i)+String.valueOf(j));
				
			}
			
		}
		
	}

	@Override
	public void decide() {
		Dijkstra dij = dij.getPath(grille, 0, 10);
		
	}

	@Override
	public boolean isDead() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void die() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Boolean getBorn() {
		// TODO Auto-generated method stub
		return null;
	}

}
