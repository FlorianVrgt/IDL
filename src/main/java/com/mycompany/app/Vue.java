package com.mycompany.app;

import java.awt.Color;
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

public class Vue implements Observer{

	public static void dessin (int width,int height, ArrayList<ArrayList<Integer>> bille) {
		int NombreCase = width * height;
		int CaseBille = bille.get(0).get(0) * bille.get(0).get(1);
		JFrame t = new JFrame();
		JPanel pan = new JPanel (new GridLayout (width,height));
		Border blackline = BorderFactory.createLineBorder(Color.black,1);
		JPanel ptest;
		for(int i = 0; i<NombreCase;i++){
			if(i+1 == CaseBille) {
			   ptest = new JPanel() {
					@Override
					public void paintComponent(Graphics g) {
						Graphics2D g2 = (Graphics2D) g;
						Shape circle = new Ellipse2D.Double(0, 0, getWidth() , getHeight());
						g2.draw(circle);
					}
				};
			}
			else {
				ptest = new JPanel();
			}
		   ptest.setBorder(blackline);
		   pan.add(ptest);
		}
		pan.setBorder(blackline);
		t.add(pan);
		t.setVisible(true);
	}

	@Override
	public void update(Observable o, Object arg) {
		ArrayList<ArrayList<Integer>> bille = new ArrayList<ArrayList<Integer>>();
		Environement env =(Environement) o;
		Agent grid[][] = env.getSma().grille;
		for(int i=0 ; i<grid.length ; i++) {
			for(int j=0 ; j<grid.length ; j++) {
				if(grid[i][j] != null) {
					ArrayList<Integer> inter = new ArrayList<Integer>();
					inter.add(i);
					inter.add(j);
					bille.add(inter);
				}
			}
		}
		List<Agent> ag = env.getSma().listeAgent;
//		dessin(grid.length,grid.length,1,1);
		// to change by print real view.
	}

}
