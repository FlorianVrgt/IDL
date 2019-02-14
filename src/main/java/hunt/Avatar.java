package hunt;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import SMA.SMA;
import core.Agent;
import core.CaseAgent;
import core.Environement;

public class Avatar extends Agent implements KeyListener{
int pasX, pasY; 
private int[][] tabDijsktra;

	public Avatar(int posX, int posY, Agent[][] grille, Environement env, SMA sma, Boolean born) {
		super(posX, posY, grille, env, sma, born);
		// TODO Auto-generated constructor stub
		pasX=0;
		pasY=1;
		this.tabDijsktra= new int[env.getSizeX()][env.getSizeY()];
		this.env.vue.addKeyListener(this);
	}

	@Override
	public void decide() {
		System.out.println("pasX: "+pasX+" pasY: "+pasY);
	int i = posX+pasX;
	int j= posY+pasY;
	
		if (i >= 0 && j >= 0 && i < env.getSizeX() && j < env.getSizeY() &&( grille[i][j]==null || !grille[i][j].getClass().equals(Wall.class)))
			move(posX, posY, posX+pasX, posY+pasY);
		setTabDijsktra(new int[env.getSizeX()][env.getSizeY()]);
		 dijstra(new CaseAgent(this.posX, this.posY),1);
		
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

	@Override
	public void keyTyped(KeyEvent e) {
	
		char c = e.getKeyChar();
		System.out.println(c);
		switch (c) {
        case 'z':  
        	pasY=-1;
        	pasX=0;
        	
            break;
        case 'd':  
        
        	pasY=0;
        	pasX=1;
            break;
        case 'q':  
        	
        	pasY=0;
        	pasX=-1;
            break;
        case 's':  
        	pasY=1;
        	pasX=0;
        	
            break;
        case 'a':  
        	pasY=-1;
        	pasX=-1;
        	
            break;
        case 'e':  
        	
        	pasY=-1;
        	pasX=1;
        	
            break;
        case 'w':  
        	pasY=1;
        	pasX=-1;
        	
            break;
        case 'c':  
        	pasY=1;
        	pasX=1;
        	
            break;
      
        default: 
                 break;
    }
		System.out.println("pasX: "+pasX+"pasY: "+pasY);
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
	
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	protected void dijstra(CaseAgent ca, int numb) {
		
		ArrayList<CaseAgent> listAgent ;
		if (getTabDijsktra()[ca.getX()][ca.getY()] == 0) {
			listAgent= env.caseAccesible(ca.getX(), ca.getY());
			// case jamais parcouru
			getTabDijsktra()[ca.getX()][ca.getY()] = numb;
			for (CaseAgent caseAgent : listAgent) {
				
				dijstra(caseAgent, numb + 1);
			
			}

		} else if (getTabDijsktra()[ca.getX()][ca.getY()] > numb) {
			getTabDijsktra()[ca.getX()][ca.getY()]=numb;
			// meilleur chemin
			listAgent= env.caseAccesible(ca.getX(), ca.getY());
			for (CaseAgent caseAgent : listAgent) {
				dijstra(caseAgent, numb + 1);
			}
		}
		
	}
	public void afficherTab() {
		for (int i = 0; i < env.getSizeX(); i++) {
			for (int j = 0; j < env.getSizeY(); j++) {
				System.out.print(getTabDijsktra()[i][j]+" |");
			}
			System.out.print("\n");
		}
		System.out.println();
	}

	public int[][] getTabDijsktra() {
		return tabDijsktra;
	}

	public void setTabDijsktra(int[][] tabDijsktra) {
		this.tabDijsktra = tabDijsktra;
	}

}
