package main;

import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Properties;

import SMA.NonEquitable;
import SMA.RdmEquitable;
import SMA.SMA;
import SMA.SequentielEquitable;
import Vue.Vue;
import core.Agent;
import core.Environement;
import core.NonTorique;
import core.Torique;
import wator.Fish;
import wator.Shark;

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
			prop.load(input);
		} catch (Exception e) {
			e.printStackTrace();
		}
		Vue vue = new Vue(prop);
		Environement env=null;

		int nbTour = Integer.parseInt(prop.getProperty("nbTour"));
		int delay = Integer.parseInt(prop.getProperty("delay"));
		int sizeX = Integer.parseInt(prop.getProperty("sizeX"));
		int sizeY = Integer.parseInt(prop.getProperty("sizeY"));
		
		SMA sma=null;
		
		if(prop.getProperty("SMA").equals("NonEquitable")) {
			sma= new NonEquitable(null, null);
		}
		
		if(prop.getProperty("SMA").equals("RdmEquitable")) {
			sma = new RdmEquitable(null,null);
		}
		
		if(prop.getProperty("SMA").equals("SequentielEquitable")) {
			sma = new SequentielEquitable(null,null);
		}

		if(prop.getProperty("type").equals("Bille"))  {
			int nbBille = Integer.parseInt(prop.getProperty("nbBille"));
			if (Boolean.parseBoolean(prop.getProperty("torique"))) {
				env = new Torique(sizeX, sizeY, nbBille, vue,sma);
			} else {
				env = new NonTorique(sizeX, sizeY, nbBille, vue,sma);
			}
		} 
		
		if(prop.getProperty("type").equals("Wator")) {
			int nbFish = Integer.parseInt(prop.getProperty("nbFish"));
			int nbShark = Integer.parseInt(prop.getProperty("nbShark"));
			if (Boolean.parseBoolean(prop.getProperty("torique"))) {
				env = new Torique(sizeX, sizeY, nbFish, nbShark, vue,sma);
			} else {
				env = new NonTorique(sizeX, sizeY, nbFish, nbShark, vue,sma);
			}
		}
		if(prop.getProperty("type").equals("Hunter")) {
			int nbHunter = Integer.parseInt(prop.getProperty("nbHunter"));
			int difficulte = Integer.parseInt(prop.getProperty("difficulte"));
			int nbWall = Integer.parseInt(prop.getProperty("nbWall"));
			if (Boolean.parseBoolean(prop.getProperty("torique"))) {
				env = new Torique(sizeX, sizeY,nbHunter,vue,difficulte,nbWall,sma);
			} else {
				env = new NonTorique(sizeX, sizeY, nbHunter,vue,difficulte,nbWall,sma);
			}
		}
		

		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter("result.csv", false));
			writer.newLine();
			for (int i = 0; i < nbTour; i++) {

				writer = new BufferedWriter(new FileWriter("result.csv", true));
				List<Agent> list = env.getListeAgent();
				int nbFish = 0;
				int nbShark = 0;
				for (Agent list1 : list) {
					if(list1 instanceof Fish) {
						nbFish++;
					}
					if(list1 instanceof Shark) {
						nbShark++;
					}
				}
				writer.append(i + "," + nbFish + "," + nbShark + ";\n");

				writer.close();

				env.step();
				try {
					Thread.sleep(delay);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
