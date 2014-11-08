package com.itstep.hometask;

/**
 * Main class to execute student's classes.
 * Each class must implement Student interface.
 * Will we go?
 * 
 * @author PP-12JavaV2
 */
public class App {
	
	static final Timchenko tim = new Timchenko();
	static final Student Putrya_D_S = new SomeClass();
    static final String dyack = "Dyachuk_Sergei";
        
	public static void main(String[] args) {
		System.out.println("Welcome fantastic team project!");
		tim.say();
                Putrya_D_S.say();

        // System.err.println(dyack + " >> Play >>>"); 
        // new Sound("src/resources/Silent_Hill.wav", 0, 2);// (path, sleep, replay)
	}
}
