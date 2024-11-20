package com.ait.qa49;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CreateAccountTests extends TestBase{

    @Test
    public void newRegistrationPositiveTest(){
        // click on register
        driver.findElement(By.cssSelector("[href='/register']")).click();

        //type first name
        driver.findElement(By.name("FirstName")).sendKeys("Marina");

        //type last name
        driver.findElement(By.name("LastName")).sendKeys("Karam");

        //type email
       // driver.findElement(By.name("Email")).click();
        driver.findElement(By.name("Email")).clear();
        driver.findElement(By.name("Email")).sendKeys("karam@gmail.com");

        //type password
      //  driver.findElement(By.name("Password")).click();
        driver.findElement(By.name("Password")).clear();
        driver.findElement(By.name("Password")).sendKeys("Karam123@");
        // type confirm password
        driver.findElement(By.name("ConfirmPassword")).clear();
        driver.findElement(By.name("ConfirmPassword")).sendKeys("Karam123@");


        // click on button register
        driver.findElement(By.id("register-button")).click();
        Assert.assertTrue(isElementPresent(By.xpath("//input[@id='register-button']")));
    }
}
