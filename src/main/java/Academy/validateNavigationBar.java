package Academy;

import Academy.pageObjects.LandingPage;
import Academy.resources.base;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;

public class validateNavigationBar extends base {
    public WebDriver driver;
    @BeforeTest
    public void initialize() throws IOException
    {
        driver = initializeDriver();//initialize the driver by calling the method from base class
        driver.get(prop.getProperty("url"));
    }
   @Test
    public void basePageNavigation() throws IOException {


        LandingPage l = new LandingPage(driver);
       Assert.assertTrue(l.getNavigationBar().isDisplayed());

           }

    @AfterTest
    public void teardown()
    {
        driver.close();
    }
}
