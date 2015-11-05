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

public class SearchAcceptanceTest {

   private WebDriver driver;

   @Test
   public void testSearchByMobileCategory() {
      String app_url = System.getProperty("APP_URL");
      driver.get(app_url);
      driver.findElement(By.linkText("Mobiles")).click();
      List<WebElement> tags = driver.findElements(By.tagName("tr"));
      Assert.assertEquals(6, tags.size());
   }

   @BeforeTest
   public void beforeTest() {
      System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
      driver = new ChromeDriver();
   }

   @AfterTest
   public void afterTest() {
      driver.quit();
   }

}
