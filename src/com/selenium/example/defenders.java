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

import com.selenium.example.Writer;
import com.selenium.example.LocalHelpers;

public class defenders {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();
    
  @Before
  public void setUp() throws Exception {
    driver = new FirefoxDriver();
    baseUrl = "https://secure.defenders.org/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testScript() throws Exception {

    LocalHelpers helpers = new LocalHelpers();
    ArrayList<String> currentAuthor = helpers.gatherWriterInfo("WriterInfo");  
    
    Writer currentWriter = new Writer(currentAuthor);
    
    driver.get(baseUrl + "/site/Advocacy?cmd=display&page=UserAction&id=2809");
    
    helpers.delay(2000);
    
    new Select(driver.findElement(By.id("title"))).selectByVisibleText(currentWriter.getPrefix());
    
    helpers.delay(2000);
    
    driver.findElement(By.id("fname")).clear();
    driver.findElement(By.id("fname")).sendKeys(currentWriter.getfirstName());

    helpers.delay(2000);
        
    driver.findElement(By.id("lname")).clear();
    driver.findElement(By.id("lname")).sendKeys(currentWriter.getlastName());
    
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
