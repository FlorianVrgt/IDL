package com.mycompany.app;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.*;
import javax.swing.border.Border;

public class vue {

	public void dessin (int width,int height, int billeX, int billeY) {
		int NombreCase = width * height + 2;
		JFrame t = new JFrame();
		JPanel pan = new JPanel (new GridLayout (10,10));
		Border blackline = BorderFactory.createLineBorder(Color.black,1); 
		for(int i = 0; i<NombreCase;i++){
		   JPanel ptest = new JPanel();
		   ptest.setBorder(blackline);
		   pan.add(ptest);
		}
		pan.setBorder(blackline);
		t.add(pan);
		t.setVisible(true);
	}
	
	public static void main(String[] args) {
		
	}

}
