package com.selenium.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class LocalHelpers {
	
	  public void delay(int timeDelay) {
		    try { Thread.currentThread().sleep(timeDelay); }
		    catch ( Exception e ) { } 
	  }
	  
	  ArrayList<String> gatherWriterInfo(String fileName) throws Exception {
			FileReader fr = new FileReader(fileName);
			BufferedReader br = new BufferedReader(fr);
			String s;
			ArrayList<String> ar = new ArrayList<String>();
			while((s = br.readLine()) != null) {
			ar.add(s);
			}
			fr.close();
			return ar;
	  }

}
