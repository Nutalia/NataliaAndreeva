package hw4.listeners;

import hw4.AllureBaseTest;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

public class AllureListener extends TestListenerAdapter {
    @Attachment(value = "Attachment: {0}", type = "image/png")
    public byte[] makeScreenshot(WebDriver driver) {
        byte[] array = {1};
        try{
            return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
        } catch(WebDriverException e) {
            e.printStackTrace();
        }
        return array;
    }

    @Override
    public void onTestFailure(ITestResult tr) {
        makeScreenshot(((AllureBaseTest)tr.getInstance()).getDriver());
    }
}
