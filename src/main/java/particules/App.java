package particules;

import Vue.Vue;
import core.Environement;
import core.NonTorique;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		Vue vue = new Vue();
		NonTorique env = new NonTorique(10, 10, 5,vue);
		//Environement env = new Environement(Integer.parseInt(args[1]), Integer.parseInt(args[2]), Integer.parseInt(args[3]),vue);
		
		System.out.println(env);
		for (int i = 0; i < 10; i++) {
			env.step();
			
			System.out.println(env);
			 try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
}
