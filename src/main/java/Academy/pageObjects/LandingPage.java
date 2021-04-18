package Academy.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {

    public WebDriver driver;

    By signIn = By.cssSelector("a[href*='sign_in']");// this is the Login button on the page- clicking on this takes to next
                                                     // page- Login page.
    By title = By.cssSelector(".text-center>h2");//title of page
    By navBar = By.xpath("//ul[@class='nav navbar-nav navbar-right']");// navigation bar on page
    By noThanxButton= By.xpath("//div[@class='sumome-react-wysiwyg-move-handle']/div/button");

    public LandingPage(WebDriver driver) {
        this.driver = driver;
    }


    public WebElement getLogin() // this method pulls out the driver.findElement signin locator

    {
        return driver.findElement(signIn);
    }

    public WebElement getTitle()
    {
        return driver.findElement(title);
    }

    public WebElement getNavigationBar()
    {
        return driver.findElement(navBar);
    }
    public WebElement noThanks()
    {
        return driver.findElement(noThanxButton);
    }

}


