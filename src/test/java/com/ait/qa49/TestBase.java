package com.ait.qa49;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class TestBase {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.get("https://demowebshop.tricentis.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }

    @AfterMethod
    public void tearDown() {
        driver.quit();

    }

    public boolean isElementPresent(By locator) {
        return driver.findElements(locator).size() > 0;

    }

    public void type(By locator, String text) {
        if (text != null) {
            click(locator);
            driver.findElement(locator).clear();
            driver.findElement(locator).sendKeys(text);
        }

    }

    public void click(By locator) {
        driver.findElement(locator).click();

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
        driver.findElement(By.name("LastName")).click();
        driver.findElement(By.name("LastName")).clear();
    }

    public void typeFirstName(String FirstName) {
        type(By.name("FirstName"), FirstName);
        driver.findElement(By.name("FirstName")).sendKeys(FirstName);
        driver.findElement(By.name("FirstName")).click();
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
}
