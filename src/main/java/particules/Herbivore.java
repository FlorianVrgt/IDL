package particules;

import java.util.ArrayList;

import SMA.SMA;
import core.Agent;
import core.CaseAgent;
import core.Environement;

public abstract class Herbivore extends Particules {

	protected int currentGestation;
	protected int gestation;

	public Herbivore(int posX, int posY, Agent[][] grille, Environement env, SMA sma, int currentGestation,
			int gestation, Boolean born) {
		super(posX, posY, grille, env, sma, born);
		this.currentGestation = currentGestation;
		this.gestation = gestation;
	}

	public void decide() {
		if (born) {
			born = false;
			return;
		}
		ArrayList<CaseAgent> caseDispo = env.caseAccesible(posX, posY);
		ArrayList<CaseAgent> canMove = new ArrayList<>();
		ArrayList<CaseAgent> listCanEat = new ArrayList<>();
		coverCase(caseDispo, canMove, listCanEat);

		if (canMove.size() >= 1) {
			// System.out.println("move");
			CaseAgent toMove = canMove.get((int) (Math.random() * canMove.size()));
			int futx = toMove.getX();
			int futy = toMove.getY();

			if (currentGestation >= gestation) {
				int antx = posX;
				int anty = posY;
				move(posX, posY, futx, futy);
				currentGestation++;
				create(antx, anty);
			} else {
				move(posX, posY, futx, futy);
				currentGestation++;
			}

		} else {
			// System.out.println("case non accesible");
		}
		if (isMustDie()) {
			die();
		}
		if (this != grille[this.posX][this.posY]) {
			System.out.println("Erreur dans herbivore");
		}

	}

	@Override
	public boolean isMustDie() {

		return false;
	}

	@Override
	public String toString() {
		return "Herbivore [currentGestation=" + currentGestation + ", gestation=" + gestation + ", posX=" + posX
				+ ", posY=" + posY + "]";
	}

	@Override
	public boolean canEat(CaseAgent ca) {

		return false;
	}

}
