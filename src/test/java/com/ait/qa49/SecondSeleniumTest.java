package com.ait.qa49;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chromium.ChromiumDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class SecondSeleniumTest {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.get("https://demowebshop.tricentis.com");

        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

       // driver.navigate().to("https://www.sport.de");

      //  driver.navigate().back();
     //   driver.navigate().forward();
      //  driver.navigate().refresh();
    }

    @Test
    public void openSiteTest() {
        System.out.println("Open site!");
    }
    @AfterMethod
    public void tearDown(){
       // driver.close();
        driver.quit();
    }
    @Test
    public void findElementBySimpleLocatorS(){

        driver.findElement(By.className("header-menu"));
        driver.findElement(By.className("header-logo"));
        driver.findElement(By.className("header-links-wrapper"));
        driver.findElement(By.className("top-menu"));
        driver.findElement(By.partialLinkText("Books"));
        driver.findElement(By.partialLinkText("Computers"));
        driver.findElement(By.partialLinkText("Electronics"));
        driver.findElement(By.linkText("Digital downloads"));
        driver.findElement(By.id("nivo-slider"));
        WebElement p = driver.findElement(By.tagName("p"));

    }
    @Test
    public void findElementByCssSelector(){
        driver.findElement(By.cssSelector("h3"));
        driver.findElement(By.cssSelector(".header"));
        driver.findElement(By.cssSelector(".header-links"));
        driver.findElement(By.cssSelector("[href^='/cart']"));
        driver.findElement(By.cssSelector(".cart-qty"));
        driver.findElement(By.cssSelector("[href^='/wishlist'"));
        driver.findElement(By.cssSelector("[href$='search']"));
        driver.findElement(By.cssSelector("#nivo-slider"));
        driver.findElement(By.cssSelector("h3"));
        driver.findElement(By.cssSelector("[href^='/sitemap']"));
    }
}

