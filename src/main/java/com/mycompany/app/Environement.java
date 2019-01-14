package com.mycompany.app;

import java.util.ArrayList;
import java.util.List;

public class Environement {
	
	
	private Agent grille[][];
	private int nbCelluleX;
	private int nbCelluleY;
	private SMA sma;
	private List<Agent> listeAgent;
	public Environement(int nbCelluleX,int nbCelluleY, int nbAgent) {
		listeAgent = new ArrayList<Agent>();
		grille= new Agent[nbCelluleX][nbCelluleY];
		Agent a = null;
		this.nbCelluleX=nbCelluleX;
		this.nbCelluleY=nbCelluleY;
		for(int i=0;i<nbAgent;i++) {
			int x = (int) (Math.random()*nbCelluleX); 
			int y = (int) (Math.random()*nbCelluleY);
			if(grille[x][y]==null) {
				int posx= (int) Math.random()*3-1;
				int posy= (int) Math.random()*3-1;
				 a = new Agent(x,y,posx,posy,grille,nbCelluleX,nbCelluleY);
				grille[x][y]= a;
				listeAgent.add(a);
			}else {
				i--;
			}
			
		}
		sma = new SMA(listeAgent,grille);
		
	}
	
	public SMA getSma() {
		return sma;
	}

	public void setSma(SMA sma) {
		this.sma = sma;
	}

	public String toString() {
		String s="";
		for (int i = 0; i < nbCelluleX; i++) {
			for (int j = 0; j < nbCelluleY; j++) {
				if(grille[i][j]!=null) {
					s+="X |";
				}else {
					s+="O |";
				}
				
			}
			s+= "\n";
		}
		return s;
	}

}
