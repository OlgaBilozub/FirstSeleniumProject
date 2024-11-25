package com.ait.qa49.homework;

import com.createaccount.fw.data.UserData;
import models.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CreateAccountTests extends TestBase {

    @BeforeMethod
    public void ensurePrecondition(){
        if (!app.getUserHelper().isRegisterPresent()) {
            app.getUserHelper().clickOnRegister();
        }
    }
    @Test
    public void newRegistrationPositiveTest(){

        app.getUserHelper().clickOnRegister();
        app.getUserHelper().fillRegistrationForm(new User()
                .setFirstName(UserData.firstName)
                .setLastName(UserData.lastName)
                .setEmail(UserData.email)
                .setPassword(UserData.password));
        app.getUserHelper().clickOnButtonRegister();

        Assert.assertTrue(app.getUserHelper().isElementPresent());

    }

}
