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
     String server_port = System.getProperty("server_port");
     driver.get("http://"+server_port+"/webshop-web");
     List<WebElement> tags = driver.findElements(By.tagName("tr"));
     Assert.assertEquals(10, tags.size());
  }
  
  
  @BeforeTest
  public void beforeTest() {
     System.setProperty("webdriver.chrome.driver", "D:/Downloads/chromedriver.exe");
     driver = new ChromeDriver();
  }

  @AfterTest
  public void afterTest() {
     driver.quit();
  }

}