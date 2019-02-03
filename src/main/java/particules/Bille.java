package particules;

import SMA.SMA;
import core.Agent;
import core.Environement;

public class Bille extends Agent{

	protected int pasX;
	protected int pasY;
	private int tailleX;
	private int tailleY;
	
	public Bille(int posX, int posY, Agent[][] grille, Environement env, SMA sma, Boolean born) {
		super(posX, posY, grille, env, sma, born);
	}

	@Override
	public void decide( ) {
		int newPoseX = posX+pasX;
		int newPoseY = posY+pasY;

		// gestion du mur 
		if(newPoseX<0) {
			pasX=1;
			newPoseX=posX;
		}
		if(newPoseY<0) {
			pasY=1;
			newPoseY=posY;
		}
		if(newPoseY>=tailleY) {
			pasY=-1;
			newPoseY=posY;

		}
		if(newPoseX>=tailleX) {
			pasX=1;
			newPoseX=posX;
		}
		Agent a = grille[newPoseX][newPoseY];
		if(a==null) {
			grille[posX][posY]=null;
			posX=newPoseX;
			posY=newPoseY;
			grille[posX][posY]=this; // potential bug;


		}
//		else { // colistion inversement de la postion
//			a.inv();
//			inv();
//			//decide();
//		}
	
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
