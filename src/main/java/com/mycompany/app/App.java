package com.mycompany.app;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		Vue vue = new Vue();
		vue.dessin(5, 5, null);
		Environement env = new Environement(5, 5, 2,vue);
		//Environement env = new Environement(Integer.parseInt(args[1]), Integer.parseInt(args[2]), Integer.parseInt(args[3]),vue);
		
		System.out.println(env);
		for (int i = 0; i < 10; i++) {
			env.step();
			
		}
		
	}
}
