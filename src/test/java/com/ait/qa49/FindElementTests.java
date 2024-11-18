package com.ait.qa49;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class FindElementTests {

    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        driver = new ChromeDriver();
        driver.get("https://ilcarro.web.app");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
    @Test
    public void findElementByTagName(){
        //find element by tag Name
        WebElement h1 = driver.findElement(By.tagName("h1"));
        System.out.println(h1.getText());

        WebElement a = driver.findElement(By.tagName("a"));
        System.out.println(a.getText());

        //find list of elements by tag name

        List<WebElement> a1 = driver.findElements(By.tagName("a"));
        System.out.println(a1.size());

    }
    @Test
    public void findElementBySimpleLocators(){
        // by id
        driver.findElement(By.id("city"));

        //by class name

        driver.findElement(By.className("header"));

        // by link Text
        driver.findElement(By.linkText("Let the car work"));

        //by partialLinkText
        driver.findElement(By.partialLinkText("car"));
    }
    @Test
    public void findElementByCssSelectorTest(){
        //tagName == css
        driver.findElement(By.cssSelector("h1"));

        //id ->css(#)
        driver.findElement(By.cssSelector("#city"));

        //className -> css(.)
        driver.findElement(By.cssSelector(".header"));

        //[attr = 'value']
        driver.findElement(By.cssSelector("[href='/login?url=%2Fsearch']"));

        // contains ->  *
        driver.findElement(By.cssSelector("[href*='login']"));

        //start ->  ^
        driver.findElement(By.cssSelector("[href^='/log']"));

        // end on -> $
        driver.findElement(By.cssSelector("[href$='search']"));
    }
}