package wator;

import java.util.ArrayList;

import SMA.SMA;
import core.Agent;
import core.CaseAgent;
import core.Environement;
import particules.Particules;

public class Shark extends Particules {




	protected int energyToReproduce;
	protected int energyToDie;
	protected int energyCurrent;
	protected int energieDefault;

	
	public Shark(int posX, int posY, Agent[][] grille, Environement env, SMA sma, Boolean born, int energyToReproduce,
			int energyToDie, int energyCurrent, int energieDefault) {
		super(posX, posY, grille, env, sma, born);
		this.energyToReproduce = energyToReproduce;
		this.energyToDie = energyToDie;
		this.energyCurrent = energyCurrent;
		this.energieDefault = energieDefault;
	}

	@Override
	public void decide() {
		if (born) {
			born = false;
			return;
		}
		ArrayList<CaseAgent> caseDispo = env.caseAccesible(posX, posY);
		ArrayList<CaseAgent> canMove = new ArrayList<>();
		ArrayList<CaseAgent> listCanEat = new ArrayList<>();
		coverCase(caseDispo, canMove, listCanEat);

		if (listCanEat.size() >= 1) {
			// System.out.println("eat");
			CaseAgent toMove = listCanEat.get((int) (Math.random() * listCanEat.size()));
		Fish f = (Fish) env.getCase(toMove);
		f.die();
			if (energyCurrent >= energyToReproduce) {
				
				int antx = posX;
				int anty = posY;
				move(posX, posY, toMove.getX(), toMove.getY());
				create(antx, anty);
				energyCurrent = energieDefault;
			} else {
				
				move(posX, posY, toMove.getX(), toMove.getY());
			}
			energyCurrent++;
		} else if (canMove.size() >= 1) {
			// System.out.println("move");
			CaseAgent toMove = canMove.get((int) (Math.random() * canMove.size()));
			int futx = toMove.getX();
			int futy = toMove.getY();

			move(posX, posY, futx, futy);
			energyCurrent--;
		} else {
			// System.out.println("case non accesible");
			energyCurrent--;
		}
		if (isMustDie()) {
			die();
		}
		
	}

	@Override
	public boolean isMustDie() {
		return energyToDie >= energyCurrent;
	}

	@Override
	public boolean canEat(CaseAgent ca) {
		return env.getCase(ca).getClass().equals(Fish.class);
	}

	@Override
	public void create(int x, int y) {

		Shark s = new Shark(x, y, grille, env, sma, born, energyToReproduce, energyToDie, energieDefault, energieDefault);
		sma.getAgentToAdd().add(s);
		grille[x][y] = s;
		if (this != grille[posX][posY]) {

			System.out.println("Erreur dans shark");
		}
		energyCurrent = energieDefault;

	}

}
