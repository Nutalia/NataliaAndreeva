package hw5.steps.hooks;

import hw5.context.TestContext;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class CucumberHook {

    @BeforeAll
    public static void initSystem() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
    }

    @Before
    public void initBrowser() {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        TestContext.getInstance().putTestObject("driver", driver);
    }

    @After
    public void closeBrowser() {
        ((WebDriver) TestContext.getInstance().getTestObject("driver")).quit();
        TestContext.getInstance().clear();
    }
}
