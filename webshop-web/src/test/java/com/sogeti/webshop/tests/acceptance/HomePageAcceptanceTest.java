package com.sogeti.webshop.tests.acceptance;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class HomePageAcceptanceTest {
  private WebDriver driver;
  
  @Test
  public void testHomePageLoad() {
     String app_url = System.getProperty("APP_URL");
     driver.get(app_url);
     List<WebElement> tags = driver.findElements(By.tagName("tr"));
     Assert.assertEquals(10, tags.size());
  }
  
  
  @BeforeTest
  public void beforeTest() {
     System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
     try{
        driver = new ChromeDriver();
     }
     catch(Exception e){
       e.printStackTrace();
     } 
     
  }

  @AfterTest
  public void afterTest() {
     driver.quit();
  }

}
