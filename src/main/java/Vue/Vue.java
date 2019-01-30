package Vue;

import java.util.Observable;
import java.util.Observer;
import java.util.Properties;

import javax.swing.JFrame;

import core.Environement;

public class Vue extends JFrame implements Observer {
	Jpan pan;
	Environement env;
	Properties prop;
	Boolean grid;

	public Vue(Properties prop) {
		this.prop = prop;
		int pixelX = Integer.parseInt(prop.get("sizePixelX").toString());
		int pixelY = Integer.parseInt(prop.get("sizePixelY").toString());
		if(prop.get("grille").toString().equals("true")) {
			this.grid = true;
		}
		else {
			this.grid = false;
		}
		pan = new Jpan(env,this.grid);
		this.setTitle("SMA et c'est facile");
		this.setSize(pixelX, pixelY);
		this.setLocationRelativeTo(null);

		this.setContentPane(pan);
		this.setVisible(true);
		this.repaint();
	}

	@Override
	public void update(Observable o, Object arg) {
		// ArrayList<ArrayList<Integer>> bille = new ArrayList<ArrayList<Integer>>();
		Environement env = (Environement) o;
		this.env = env;
		pan.setEnv(env);
		pan.repaint();

	}

}
