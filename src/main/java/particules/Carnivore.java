package particules;

import java.util.ArrayList;
import java.util.Arrays;

import core.Agent;
import core.CaseAgent;
import core.Environement;
import core.SMA;
import wator.Fish;
import wator.Shark;

public abstract class Carnivore extends Particules {
	protected int energyToReproduce;
	protected int energyToDie;
	protected int energyCurrent;
	protected int energieDefault;




	
	public Carnivore(int posX, int posY, Agent[][] grille, Environement env, SMA sma, int energyToReproduce,
			int energyToDie, int energyCurrent, int energieDefault,Boolean born) {
		super(posX, posY, grille, env, sma,born);
		this.energyToReproduce = energyToReproduce;
		this.energyToDie = energyToDie;
		this.energyCurrent = energyCurrent;
		this.energieDefault = energieDefault;
	}

	@Override
	public void decide() {
		if(born) {
			born=false;
		}
		ArrayList<CaseAgent> caseDispo = env.caseAccesible(posX, posY);
		ArrayList<CaseAgent> canMove = new ArrayList<>();
		ArrayList<Agent> listCanEat = new ArrayList<>();
		coverCase(caseDispo, canMove, listCanEat);

		if (listCanEat.size() >= 1) {
			// System.out.println("eat");
			Agent toMove = listCanEat.get((int) (Math.random() * listCanEat.size()));
			int futx = toMove.getPosX();
			int futy = toMove.getPosY();
			
			if (energyCurrent >= energyToReproduce) {
				int antx = posX;
				int anty = posY;
				move(posX, posY, futx, futy);
				create(antx, anty);
				energyCurrent = energieDefault;
			} else {
				move(posX, posY, futx, futy);
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
			//System.out.println("case non accesible");
			energyCurrent--;
		}
		if(isMustDie()) {
			die();
		}
	}

	@Override
	public boolean isMustDie() {
		return energyToDie>=energyCurrent;
	}

	
	@Override
	public boolean canEat(CaseAgent ca) {
		return env.getCase(ca).getClass().equals(Fish.class);
	}

	@Override
	public String toString() {
		return "Carnivore [energyToReproduce=" + energyToReproduce + ", energyToDie=" + energyToDie + ", energyCurrent="
				+ energyCurrent + ", energieDefault=" + energieDefault + ", posY=" + posY +", posX=" + posX + "]";
	}

	

}
