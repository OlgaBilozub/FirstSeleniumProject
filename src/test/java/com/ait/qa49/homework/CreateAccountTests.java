package com.ait.qa49.homework;

import com.createaccount.fw.data.UserData;
import models.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utils.DataProviders;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

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


    @Test(dataProvider = "addNewContact",dataProviderClass = DataProviders.class)
    public void newRegistrationPositiveFromDataProviderTest(String firstName,String lastName,
                                                            String email,String password){

        app.getUserHelper().clickOnRegister();
        app.getUserHelper().fillRegistrationForm(new User()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmail(email)
                .setPassword(password));
        app.getUserHelper().clickOnButtonRegister();

        Assert.assertTrue(app.getUserHelper().isElementPresent());

    }


    @Test(dataProvider = "addNewContactWithCsv",dataProviderClass = DataProviders.class)
    public void newRegistrationPositiveFromDataProviderWithCsvFileTest(User user){

        app.getUserHelper().clickOnRegister();
        app.getUserHelper().fillRegistrationForm(user);

        app.getUserHelper().clickOnButtonRegister();

        Assert.assertTrue(app.getUserHelper().isElementPresent());

    }

}
