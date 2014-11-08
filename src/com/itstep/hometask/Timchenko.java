package com.itstep.hometask;

public class Timchenko implements Student {

	private String message = "Hi to all. Get involved in conversation like me...";
	
	@Override
	public void say() {
		System.out.println(message);		
	}
	
	public void say(String text) {
		System.out.println(text);		
	}
	
}
