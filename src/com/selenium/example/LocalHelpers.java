package com.selenium.example;

public class LocalHelpers {
	
	  public void delay(int timeDelay) {
		    try { Thread.currentThread().sleep(timeDelay); }
		    catch ( Exception e ) { } 
	  }

}
