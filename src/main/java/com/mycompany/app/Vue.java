package com.mycompany.app;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

import javax.swing.*;
import javax.swing.border.Border;

public class Vue implements Observer {
	JFrame jframe;
	Jpan pan;
	Environement env;

	public void dessin(int width, int height, ArrayList<ArrayList<Integer>> bille) {
		int NombreCase = width * height;
		
		JFrame t = new JFrame();
		
		Border blackline = BorderFactory.createLineBorder(Color.black, 1);
		
		
		Jpan pan = new Jpan(env);
		pan.setLayout(new GridLayout(width, height));
		t.add(pan);
		t.setVisible(true);
		this.jframe = t;
		this.pan = pan;
		pan.setBorder(blackline);
		pan.repaint();
		
	}

	public static void main(String[] args) {
		new Vue().dessin(10, 10, null);
	}

	@Override
	public void update(Observable o, Object arg) {
		//ArrayList<ArrayList<Integer>> bille = new ArrayList<ArrayList<Integer>>();
		Environement env = (Environement) o;
		this.env= env;
		pan.setEnv(env);
		pan.repaint();
		
		//dessin(env.getSizeX(), env.getSizeY(), 1, 1);

//		Agent grid[][] = env.getSma().grille;
//		for(int i=0 ; i<grid.length ; i++) {
//			for(int j=0 ; j<grid.length ; j++) {
//				if(grid[i][j] != null) {
//					ArrayList<Integer> inter = new ArrayList<Integer>();
//					inter.add(i);
//					inter.add(j);
//					bille.add(inter);
//				}
//			}
//		}
		List<Agent> ag = env.getSma().listeAgent;
//		dessin(grid.length,grid.length,1,1);

	}

}
