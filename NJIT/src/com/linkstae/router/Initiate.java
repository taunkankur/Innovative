package com.linkstae.router;

public class Initiate implements Runnable{

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		
		
	}
	
	public static void main(String[] args) {
		
		
		Thread router1=new Thread(new Initiate(),"Router1");
		
		Thread router2=new Thread(new Initiate(),"Router2");
	
		router1.start();
		router2.start();
	}
	
	
	
}