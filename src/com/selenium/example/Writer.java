package com.selenium.example;

import java.util.ArrayList;


public class Writer {
    
    private String prefix;
    private String firstName;
    private String lastName;
        
    public Writer(ArrayList<String> authorInfo) {
    	
    	
        prefix = authorInfo.get(0);
        firstName = authorInfo.get(1);
        lastName = authorInfo.get(2);
    }
    
    public String getPrefix() {
    	return prefix;
    };
    
    public String getfirstName() {
    	return firstName;
    };
    
    public String getlastName() {
    	return lastName;
    };
    
//    public String toString() {
//        return this.prefix + ", " + this.firstName + ", " + this.lastName;
//    }
//    
}