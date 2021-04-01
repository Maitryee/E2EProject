package Academy;

import Academy.pageObjects.LandingPage;
import Academy.pageObjects.LoginPage;
import Academy.resources.base;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class HomePage extends base {
    public WebDriver driver;

    @BeforeTest
    public void initialize() throws IOException
    {
        driver = initializeDriver();//initialize the driver by calling the method from base class


    }
    @Test(dataProvider = "getData")
    public void basePageNavigation(String Username,String Password,String text) throws IOException
    {
        driver.get(prop.getProperty("url"));
        //System.out.println(prop.values());
        LandingPage l = new LandingPage(driver);// instantiating the class LandingPage so that we use the methods of that class
                                           // with its object -l
        l.getLogin().click(); //we will use the method getLogin here so that we dont have to hardcode it so that in future if the
                    // login object in the page is changed then we have to go to every tc where login is used and change it.
        LoginPage lp = new LoginPage(driver);
        lp.getEmail().sendKeys(Username);
        lp.getPassword().sendKeys(Password);
        System.out.println(text);
        lp.submitPassword().click();


    }


    @DataProvider
            public Object[][] getData() {
        Object[][] data = new Object[2][3];

        data[0][0] = "tester1@email.com";
        data[0][1] = "12341";
        data[0][2] = "restricted user";

        data[1][0] = "tester2@email.com";
        data[1][1] = "tester2";
        data[1][2] = "non restricted user";

        return data;
    }

        @AfterTest
        public void teardown ()
        {
            driver.close();
        }



}
