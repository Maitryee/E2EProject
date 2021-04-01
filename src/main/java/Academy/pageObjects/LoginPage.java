package Academy.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

    public WebDriver driver;//creating a driver object

    By email= By.xpath("//input[@id='user_email']");
    By password=By.cssSelector("#user_password");
    By submitPassword=By.xpath("//input[@value='Log In']");

    //we are storing css selector in email.'By' declaration-that is to declare it single time and call multiple times.
    // Its applicable for same class and other class also.You can access it in other class by Public declaration.

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getEmail() // this method pulls out the driver.findElement signin locator

    {
        return driver.findElement(email);//we are returning the value of signIn to the getLogin() and since it the signIn
                                         // is a webelement - LOGIN BUTTON - on the webpage the return type of the method
                                         // is Webelement.

    }
    public WebElement getPassword()
    {
        return driver.findElement(password);
    }

    public WebElement submitPassword()
    {
    return driver.findElement(submitPassword);
    }

}
