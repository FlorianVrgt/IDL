package hunt;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import SMA.SMA;
import core.Agent;
import core.Environement;

public class Avatar extends Agent implements KeyListener{
int pasX, pasY; 

	public Avatar(int posX, int posY, Agent[][] grille, Environement env, SMA sma, Boolean born) {
		super(posX, posY, grille, env, sma, born);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void decide() {
		
	int i = posX+pasX;
	int j= posY+pasY;
		if (i >= 0 && j >= 0 && i < env.getSizeX() && j < env.getSizeY())
		move(posX, posY, pasX, pasY);
		
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
		switch (c) {
        case 'z':  
        	pasY=1;
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
        	pasY=-1;
        	pasX=0;
            break;
      
        default: 
                 break;
    }
	}

	@Override
	public void keyPressed(KeyEvent e) {
		
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}
