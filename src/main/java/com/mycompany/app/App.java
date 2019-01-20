package com.mycompany.app;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		Vue vue = new Vue();
		Environement env = new Environement(5, 5, 2,vue);
		
		
		System.out.println(env);
		for (int i = 0; i < 100; i++) {
			env.step();
			
		}
		
	}
}
