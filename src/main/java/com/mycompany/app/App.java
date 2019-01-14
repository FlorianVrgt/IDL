package com.mycompany.app;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		Environement env = new Environement(5, 5, 1);
		System.out.println(env);
		for (int i = 0; i < 100; i++) {
			env.getSma().run();
			System.out.println(env);
		}
		
	}
}
