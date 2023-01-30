package com.vv.vvclock;

import com.vv.vvclock.Clock;

public class ClockMain {

	public static void main(String[] args) {
		Clock clockName = new Clock();
		
		clockName.init();
		
		
		//creating a new thread here
		Thread clockThread = new Thread(){
			@Override
			public void run() {
				System.out.println("Clock Thread started");
				//on a seperate thread
				while(true){
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					
					clockName.refresh();
				}
			}
		};
		clockThread.start();
		
	}

}
