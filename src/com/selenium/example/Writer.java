package com.selenium.example;

import java.util.ArrayList;


public class Writer {
    
    private String prefix;
    private String firstName;
    private String lastName;
    private String email;
    private String address1;
    private String address2;
    private String city;
    private String state;
    private String zip;
    private String receiveMoreInfo;
    private String url;
        
    public Writer(ArrayList<String> authorInfo) {
        prefix = authorInfo.get(0);
        firstName = authorInfo.get(1);
        lastName = authorInfo.get(2);
        email = authorInfo.get(3);
        address1 = authorInfo.get(4);
        address2 = authorInfo.get(5);
        city = authorInfo.get(6);
        state = authorInfo.get(7);
        zip = authorInfo.get(8);
        receiveMoreInfo = authorInfo.get(9);
        url = authorInfo.get(10);
    }
    
    public String getPrefix() {
    	return prefix;
    };
    
    public String getFirstName() {
    	return firstName;
    };
    
    public String getLastName() {
    	return lastName;
    };
    
    public String getEmail() {
    	return email;
    };
    
    public String getAddress1() {
    	return address1;
    }; 
    
    public String getAddress2() {
    	return address2;
    }; 
    
    public String getCity() {
    	return city;
    };
    
    public String getState() {
    	return state;
    };
    
    public String getZip() {
    	return zip;
    };
    
    public String getReceiveMoreInfo() {
    	return receiveMoreInfo;
    };    
    
    public String getUrl() {
    	return url;
    };
    
//    public String toString() {
//        return this.prefix + ", " + this.firstName + ", " + this.lastName;
//    }
//    
}