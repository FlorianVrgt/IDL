package particules;

import SMA.SMA;
import core.Agent;
import core.Environement;

public class Bille extends Agent{

	protected int pasX=(int) Math.random()*3-1;
	protected int pasY=(int) Math.random()*3-1;
	private int tailleX = env.getSizeX();
	private int tailleY = env.getSizeY();
	
	public Bille(int posX, int posY, Agent[][] grille, Environement env, SMA sma, Boolean born) {
		super(posX, posY, grille, env, sma, born);
	}

	@Override
	public void decide() {
		System.out.println("le pas " + pasX);
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
			pasX=-1;
			newPoseX=posX;
		}
		Agent a = grille[newPoseX][newPoseY];
		System.out.println("pos : " + posX + " " + posY + " newpos : " + newPoseX + " " + newPoseY);
		if(a==null) {
			move(posX,posY,newPoseX,newPoseY);
		}
		else {
			((Bille) a).inv();
			inv();
		}
	
	}
	
	public void move(int x, int y, int futx, int futy) {
		if (this != grille[posX][posY]) {
			System.out.println("Erreur");
		}
		// System.out.println("x:"+x+" y:"+y+"futx:"+futx+"futy: "+futy);
		System.out.println(env.caseAccesible(x, y));
		grille[futx][futy] = this;
		grille[x][y] = null;
		posX = futx;
		posY = futy;
		if (this != grille[posX][posY]) {
			System.out.println("Erreur move");
		}
	}
	
	public void inv() {
		pasX*=-1;
		pasY*=-1;
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
