package particules;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

import Vue.Vue;
import core.Environement;
import core.NonTorique;
import core.Torique;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		final Properties prop = new Properties();
		InputStream input = null;

		try {

			input = new FileInputStream("properties");

			// load a properties file
			prop.load(input);
		}catch (Exception e) {
			e.printStackTrace();
		}
		int nbTour= Integer.parseInt(prop.getProperty("nbTour"));
		int delay = Integer.parseInt(prop.getProperty("delay"));
		Vue vue = new Vue();
		Environement env;
		int sizeX =Integer.parseInt(prop.getProperty("sizeX"));
		int sizeY =Integer.parseInt(prop.getProperty("sizeY"));
		int nbAgent =Integer.parseInt(prop.getProperty("nbAgent"));
		if(Boolean.parseBoolean(prop.getProperty("torique"))) {
		 env = new NonTorique(sizeX, sizeY,nbAgent, vue);
		}else {
			env = new Torique(sizeX, sizeY, nbAgent, vue);
		}
		for (int i = 0; i < nbTour; i++) {
			env.step();

			try {
				Thread.sleep(delay);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			
			
			
		}

	}
}
