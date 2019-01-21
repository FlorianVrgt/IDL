package com.mycompany.app;

import java.awt.GraphicsEnvironment;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;

public class Vue extends JFrame implements Observer {
	Jpan pan;
	Environement env;

	public static void main(String[] args) {
		new Vue();
	}

	public Vue() {

		pan = new Jpan(env);
		this.setTitle("Ma première fenêtre Java");
		GraphicsEnvironment.getLocalGraphicsEnvironment();
		this.setExtendedState(this.getExtendedState() | this.MAXIMIZED_BOTH);
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
