package main;

import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
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
			prop.load(input);
		} catch (Exception e) {
			e.printStackTrace();
		}
		Vue vue = new Vue(prop);
		Environement env;

		int nbTour = Integer.parseInt(prop.getProperty("nbTour"));
		int delay = Integer.parseInt(prop.getProperty("delay"));
		int sizeX = Integer.parseInt(prop.getProperty("sizeX"));
		int sizeY = Integer.parseInt(prop.getProperty("sizeY"));

		if (Boolean.parseBoolean(prop.getProperty("bille"))) {
			int nbBille = Integer.parseInt(prop.getProperty("nbBille"));
			if (Boolean.parseBoolean(prop.getProperty("torique"))) {
				env = new Torique(sizeX, sizeY, nbBille, vue);
			} else {
				env = new NonTorique(sizeX, sizeY, nbBille, vue);
			}
		} else {
			int nbFish = Integer.parseInt(prop.getProperty("nbFish"));
			int nbShark = Integer.parseInt(prop.getProperty("nbShark"));
			if (Boolean.parseBoolean(prop.getProperty("torique"))) {
				env = new Torique(sizeX, sizeY, nbFish, nbShark, vue);
			} else {
				env = new NonTorique(sizeX, sizeY, nbFish, nbShark, vue);
			}
		}

		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter("result.txt", false));
			writer.newLine();
			for (int i = 0; i < nbTour; i++) {

				writer = new BufferedWriter(new FileWriter("result.csv", true));
				writer.append(i + "," + env.getListeAgent().size() + ";\n");

				writer.close();

				env.step();

			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
