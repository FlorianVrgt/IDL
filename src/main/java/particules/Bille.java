package particules;

import SMA.SMA;
import core.Agent;
import core.Environement;
import core.NonTorique;
import core.Torique;

public class Bille extends Agent{

	protected int pasX;
	protected int pasY;
	private int tailleX = env.getSizeX();
	private int tailleY = env.getSizeY();
	
	public Bille(int posX, int posY, Agent[][] grille, Environement env, SMA sma, Boolean born) {
		super(posX, posY, grille, env, sma, born);
		pasX=(int) (Math.random()*3)-1;
		pasY= (int) (Math.random()*3)-1;
		while(pasX == 0 && pasY == 0) {
			pasX=(int) (Math.random()*3)-1;
			pasY= (int) (Math.random()*3)-1;
		}
		
		
	}

	@Override
	public void decide() {
		
		int newPoseX = posX+pasX;
		int newPoseY = posY+pasY;
		
		int toriqueX;
		int toriqueY;

		// gestion du mur 
		if(env.getClass() == NonTorique.class) {
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
		}
		else {
			if(newPoseX<0) {
				newPoseX=tailleX-1;
			}
			if(newPoseY<0) {
				newPoseY=tailleY-1;
			}
			if(newPoseY>=tailleY) {
				newPoseY=0;
			}
			if(newPoseX>=tailleX) {
				newPoseX=0;
			}
		}
		Agent a = grille[newPoseX][newPoseY];
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



}
