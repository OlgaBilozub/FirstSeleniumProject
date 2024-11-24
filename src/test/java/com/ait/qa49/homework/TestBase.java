package com.ait.qa49.homework;
import com.createaccount.fw.AppManager;
import org.openqa.selenium.remote.Browser;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class TestBase {

    protected static AppManager app = new AppManager(System.getProperty("browser",
            Browser.CHROME.browserName()));
@BeforeSuite
   // @BeforeMethod
    public void setUp() {
        app.init();
    }
@AfterSuite
  //  @AfterMethod
    public void tearDown() {
        app.stop();
    }
}
