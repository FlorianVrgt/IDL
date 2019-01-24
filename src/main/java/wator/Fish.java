package wator;

import java.util.ArrayList;
import java.util.List;

import core.Agent;
import core.CaseAgent;
import core.Environement;
import particules.Particules;

public class Fish extends Particules {



	public Fish(int posX, int posY, int pasX, int pasY, Agent[][] grille, int tailleX, int tailleY, int gestation,
			Environement env) {
		super(posX, posY, pasX, pasY, grille, tailleX, tailleY, gestation, env);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void decide() {
		ArrayList<CaseAgent> caseDispo = env.caseAccesible(posX, posY);
		ArrayList<CaseAgent> canMove = new ArrayList<>();
		for (CaseAgent ca : caseDispo) {
			if (grille[ca.getX()][ca.getY()] == null) {
				canMove.add(new CaseAgent(ca.getX(), ca.getY()));
			}

		}
		if (canMove.size() >= 1) {
			CaseAgent toMove = canMove.get((int) (Math.random() * canMove.size()));
			int futx = toMove.getX();
			int futy = toMove.getY();
			
			if(currentGestation>=gestation) {
				int antx= posX;
				int anty= posY;
				move(posX, posY, futx, futy);
				create(antx, anty);
			}else {
				move(posX, posY, futx, futy);
			}
			
			
		} else {
			System.out.println("case non accesible");
		}

	}

	@Override
	public void create(int x, int y) {
		grille[x][y]=new Fish(x, y, pasX, pasY, grille, tailleX, tailleY, gestation,env);
		
		
	}

	@Override
	public boolean isMustDie() {
		return false;
	}

}
