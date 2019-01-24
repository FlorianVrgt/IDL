package wator;

import java.util.ArrayList;

import core.Agent;
import core.CaseAgent;
import core.Environement;
import particules.Particules;

public class Shark extends Particules {



	public Shark(int posX, int posY, int pasX, int pasY, Agent[][] grille, int tailleX, int tailleY, int gestation,
			Environement env) {
		super(posX, posY, pasX, pasY, grille, tailleX, tailleY, gestation, env);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void decide() {
		ArrayList<CaseAgent> caseDispo =env.caseAccesible(posX, posY);
		ArrayList<Agent> canEat = new ArrayList<>();
		ArrayList<CaseAgent> canMove = new ArrayList<>();
		for (CaseAgent ca: caseDispo) {
					if(grille[ca.getX()][ca.getY()]==null) {
						canMove.add(new CaseAgent(ca.getX(), ca.getY()));
					}else if(grille[ca.getX()][ca.getY()].getClass().equals(Fish.class)) {
						canEat.add(grille[ca.getX()][ca.getY()]);
					}
			}
			if(canEat.size()>=1) {
				Agent toEat =canEat.get((int)(Math.random()*canEat.size()));
				this.posX=toEat.getPosX();
				this.posY=toEat.getPosY();
				toEat.die();
				grille[posX][posY]=this;
			}else if(canMove.size()>=1){
				CaseAgent toMove =canMove.get((int)(Math.random()*canMove.size()));
				this.posX=toMove.getX();
				this.posY=toMove.getY();
			}else {
				System.out.println("case non accesible");
			}
			
			
		}

	@Override
	public boolean isMustDie() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void create(int x, int y) {
		grille[x][y]= new Shark(x, y, pasX, pasY, grille, tailleX, tailleY, gestation,env);
	}

}
