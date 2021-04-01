package Academy.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {

    public WebDriver driver;//creating a driver object

    By signIn= By.cssSelector("a[href*='sign_in']");//we are storing css selector in signin.'By'->declaration-that is to declare it
    // single time and call multiple times. Its applicable for same class and other class also.You can access it in other class
    // by Public declaration.
    By title= By.cssSelector(".text-center>h2");
    By navBar= By.xpath("//ul[@class='nav navbar-nav navbar-right']");



    public LandingPage(WebDriver driver) {
        this.driver = driver;
    }


    public WebElement getLogin() // this method pulls out the driver.findElement signin locator

    {
        return driver.findElement(signIn);//we are returning the value of signIn to the getLogin() and since it the signIN
                                         // is a webelement - LOGIN BUTTON - on the webpage the return type of the method
                                         // is Webelement.
    }

    public WebElement getTitle()
    {
        return driver.findElement(title);
    }

    public WebElement getNavigationBar()
    {
        return driver.findElement(navBar);
    }

}


