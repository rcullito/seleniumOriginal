package com.selenium.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;

import org.junit.*;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import java.net.InetAddress; 
import java.net.UnknownHostException; 
 
import org.slf4j.Logger; 
import org.slf4j.LoggerFactory;

import com.datastax.driver.core.Cluster; 
import com.datastax.driver.core.Session; 
import com.datastax.driver.core.querybuilder.QueryBuilder; 



import com.selenium.example.Writer;
import com.selenium.example.LocalHelpers;

public class defenders {
  private WebDriver driver;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();
  
    
  @Before
  public void setUp() throws Exception {
    driver = new FirefoxDriver();
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testScript() throws Exception {

	  Cluster cluster;
	  Session session;
	  
	// Connect to the cluster and keyspace "demo"
	  cluster = Cluster.builder().addContactPoint("127.0.0.1").build();
	  session = cluster.connect("demo");
	  
	  session.execute("INSERT INTO users (lastname, age, city, email, firstname) VALUES ('Jones', 35, 'Austin', 'bob@example.com', 'Bob')");

	  
	  
    LocalHelpers helpers = new LocalHelpers();
    ArrayList<String> currentAuthor = helpers.gatherWriterInfo("WriterInfo");  
    
    Writer currentWriter = new Writer(currentAuthor);
    
    driver.get(currentWriter.getUrl());
    
    helpers.delay(2000);
    
    new Select(driver.findElement(By.id("title"))).selectByVisibleText(currentWriter.getPrefix());
    driver.findElement(By.id("fname")).clear();
    driver.findElement(By.id("fname")).sendKeys(currentWriter.getFirstName());    
    driver.findElement(By.id("lname")).clear();
    driver.findElement(By.id("lname")).sendKeys(currentWriter.getLastName());
    driver.findElement(By.id("street1")).clear();
    driver.findElement(By.id("email")).sendKeys(currentWriter.getEmail());
    driver.findElement(By.id("street1")).clear();
    driver.findElement(By.id("street1")).sendKeys(currentWriter.getAddress1());
    driver.findElement(By.id("city")).clear();
    helpers.delay(8000);
    driver.findElement(By.id("city")).sendKeys(currentWriter.getCity());
    new Select(driver.findElement(By.id("state"))).selectByVisibleText(currentWriter.getState());    
    driver.findElement(By.id("zip")).clear();
    driver.findElement(By.id("zip")).sendKeys(currentWriter.getZip()); 
    // need to find a better way around this option
    helpers.delay(2000);
    new Select(driver.findElement(By.id("1428_34940_5_42561"))).selectByVisibleText(currentWriter.getReceiveMoreInfo());
    helpers.delay(8000);
    driver.findElement(By.id("send")).click(); 
    helpers.delay(2000);
  }

  
  @After
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
}
