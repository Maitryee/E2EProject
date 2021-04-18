package Academy.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

    public WebDriver driver;//creating a driver object

    //By email= By.xpath("//input[@id='user_email']");(*)
    By password=By.cssSelector("#user_password");
    By submitPassword=By.xpath("//input[@value='Log In']");

    //we are storing css selector in email.'By' declaration-that is to declare it single time and call multiple times.
    // Its applicable for same class and other class also.You can access it in other class by Public declaration.

    public LoginPage(WebDriver driver) //constructor to initialize the instance variable - 'driver'
    {
        this.driver = driver;
    }

    public WebElement getEmail() //this is a diff way of doing same thing as line31

    {
       WebElement email;//object for WebElement
       email = driver.findElement(By.xpath("//input[@id='user_email']"));//put value in the variable -email

       return email;//return email to method
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
