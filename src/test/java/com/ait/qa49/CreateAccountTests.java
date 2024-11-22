package com.ait.qa49;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CreateAccountTests extends TestBase{

    @Test

    public void newRegistrationPositiveTest(){

        clickOnRegister();
        fillRegistrationForm(new User()
                .setFirstName("Marina")
                .setLastName("Karam")
                .setEmail("Karam@gmail.com")
                .setPassword("Karam123@"));
        clickOnButtonRegister();

        Assert.assertTrue(isElementPresent());

    }

}
