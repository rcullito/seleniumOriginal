package com.selenium.example;


public class Writer {
    
    private String prefix;
    private String firstName;
    private String lastName;
        
    public Writer(String startPrefix, String startFirstName, String startLastName) {
        prefix = startPrefix;
        firstName = startFirstName;
        lastName = startLastName;
    }
    
    public String getPrefix() {
    	return prefix;
    }
    
    public String toString() {
        return this.prefix + ", " + this.firstName + ", " + this.lastName;
    }
    
}