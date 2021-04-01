package Academy;

import Academy.resources.base;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listeners extends base implements ITestListener {

    public void onTestSuccess(ITestResult result) {

    }

    public void onTestFailure(ITestResult result) {
        WebDriver driver=null;

        String testMethodName=result.getMethod().getMethodName();
        try {
            driver = (WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
        } catch (Exception e) {

        }
        getScreenshotPath(testMethodName,driver);




    }

    public void onTestSkipped(ITestResult result) {

    }

    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

    }

    public void onTestFailedWithTimeout(ITestResult result) {

    }

    public void onStart(ITestContext context) {

    }

    public void onFinish(ITestContext context) {

    }

    public void onTestStart(ITestResult result) {

    }
}
