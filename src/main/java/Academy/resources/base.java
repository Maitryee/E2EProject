package Academy.resources;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;


public class base {

    public WebDriver driver;//we define it at global level so that we create driver object only once and can be used for all classes in the testcase
    public Properties prop;
    public WebDriver initializeDriver() throws IOException
    {
        prop= new Properties();//we create a data driven properties file so that we dont have to hard code the data
        FileInputStream fis=new FileInputStream("C:\\Users\\maitr\\IdeaProjects\\E2EProject\\src\\main\\java\\Academy\\resources\\data.properties");
        prop.load(fis);
        String browserName=prop.getProperty("browser");

        if(browserName.equals("chrome"))
        {

            System.setProperty("webdriver.chrome.driver", "C:\\Selenium jars and drivers\\Drivers\\Chrome\\chromedriver.exe");

             driver = new ChromeDriver();
        }
        else if (browserName.equals("Firefox"))
        {
            //execute in firefox driver
            System.setProperty("webdriver.gecko.driver", "C:\\Selenium jars and drivers\\Drivers\\Firefox\\geckodriver.exe");
             driver = new FirefoxDriver();

        }
        else if (browserName.equals("IE"))
        {
            //execute in IE browser
            System.setProperty("webdriver.IE.driver", "C:\\Selenium jars and drivers\\Drivers\\IE\\IEDriverServer.exe");
             driver = new InternetExplorerDriver();
        }
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);// we set timeout for page to load and this wait is applicable to all
        // if the req for page load changes and we have to wait for 20 secs then change 10 to 20
        return driver;
    }

    public void getScreenshotPath(String testCaseName, WebDriver driver){
        TakesScreenshot screenshot = (TakesScreenshot) driver;
        File source =screenshot.getScreenshotAs(OutputType.FILE);
        String destinationFile = System.getProperty("user.dir")+"\\reports\\"+testCaseName + ".png";
        try {
            FileUtils.copyFile(source,new File(destinationFile));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
