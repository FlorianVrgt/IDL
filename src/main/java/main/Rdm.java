package main;

import java.util.Random;

public final class Rdm {
	static Random rdm;
	public  Rdm() {
		rdm= new Random(100);
	}
	public static Random get() {
		return rdm;
	}
	
}
