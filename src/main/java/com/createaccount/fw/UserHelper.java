package com.createaccount.fw;

import models.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class UserHelper extends BaseHelper {
    public UserHelper(WebDriver driver) {
        super(driver);
    }

    public void clickOnButtonRegister() {
        click(By.id("register-button"));
    }

    public void typeConfirmPassword(String ConfirmPassword) {
        type(By.name("ConfirmPassword"), ConfirmPassword);
        driver.findElement(By.name("ConfirmPassword")).clear();
        driver.findElement(By.name("ConfirmPassword")).sendKeys(ConfirmPassword);
    }

    public void typePassword(String Password) {
        //  driver.findElement(By.name("Password")).click();
        type(By.name("Password"), Password);
        driver.findElement(By.name("Password")).clear();
        driver.findElement(By.name("Password")).sendKeys(Password);
    }

    public void typeEmail(String email) {
        // driver.findElement(By.name("Email")).click();
        type(By.name("Email"), email);
        driver.findElement(By.name("Email")).clear();
        driver.findElement(By.name("Email")).sendKeys(email);
    }

    public void typeLastName(String LastName) {
        type(By.name("LastName"), LastName);
        driver.findElement(By.name("LastName")).sendKeys(LastName);
        click(By.name("LastName"));
        driver.findElement(By.name("LastName")).clear();
    }

    public void typeFirstName(String FirstName) {
        type(By.name("FirstName"), FirstName);
        driver.findElement(By.name("FirstName")).sendKeys(FirstName);
        click(By.name("FirstName"));
        driver.findElement(By.name("FirstName")).clear();
    }

    public void clickOnRegister() {
        click(By.cssSelector("[href='/register']"));
    }

    public boolean isElementPresent() {
        return isElementPresent(By.xpath("//input[@id='register-button']"));
    }

    public void fillRegistrationForm(User user) {
        typeFirstName(user.getFirstName());
        typeLastName(user.getLastName());
        typeEmail(user.getEmail());
        typePassword(user.getPassword());
        typeConfirmPassword(user.getPassword());
    }

    public boolean isRegisterPresent() {
        return isElementPresent(By.cssSelector("[href='/register']"));
    }
}
