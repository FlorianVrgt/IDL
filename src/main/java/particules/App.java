package particules;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

import Vue.Vue;
import core.NonTorique;

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
		NonTorique env = new NonTorique(Integer.parseInt(prop.getProperty("sizeX")), Integer.parseInt(prop.getProperty("sizeY")),Integer.parseInt(prop.getProperty("nbAgent")), vue);
		// NonTorique env = new NonTorique(5, 5, 2,vue);
		// Environement env = new Environement(Integer.parseInt(args[1]),
		// Integer.parseInt(args[2]), Integer.parseInt(args[3]),vue);

		System.out.println(env);
		for (int i = 0; i < nbTour; i++) {
			env.step();

			//System.out.println(env);

			try {
				Thread.sleep(delay);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("nb mort"+env.die );
			env.die=0;
			System.out.println("nb tour"+i);
		}

	}
}
