package com.mycompany.app;

import java.util.Arrays;

public class Agent {
	private int posX;
	private int posY;
	private int pasX;
	private int pasY;
	private int tailleX;
	private int tailleY;
	private Agent grille[][];
	public Agent(int posX, int posY, int pasX, int pasY,Agent grille[][],int tailleX,int tailleY) {
		super();
		this.posX = posX;
		this.posY = posY;
		this.pasX = pasX;
		this.pasY = pasY;
		this.tailleX=tailleX;
		this.tailleY=tailleY;
		this.grille=grille;
	}

	/*
	 * fonction pour donner la main à l'agent
	 * change de position et de pas.
	 */
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
			
			
		}else { // colistion inversement de la postion
			a.inv();
			inv();
			//decide();
		}
		//System.out.println(this);
		
	}
	
	@Override
	public String toString() {
		return "Agent [posX=" + posX + ", posY=" + posY + ", pasX=" + pasX + ", pasY=" + pasY + ", tailleX=" + tailleX
				+ "]";
	}

	public void inv() {
		pasX*=-1;
		pasY*=-1;
	}

}
