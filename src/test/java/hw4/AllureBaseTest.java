package hw4;

import hw3.UserData;
import hw4.steps.ActionStep;
import hw4.steps.AssertStep;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.TestListenerAdapter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.io.FileReader;
import java.time.Duration;
import java.util.Properties;


public class AllureBaseTest extends TestListenerAdapter {
    protected String homeUrl;
    protected Properties properties;
    protected ActionStep actionStep;
    protected AssertStep assertStep;

    public WebDriver getDriver() {
        return actionStep.getDriver();
    }

    @BeforeSuite(description = "Set path to chrome driver")
    public void initSystem() {
        String path = "src/main/resources/chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", path);
    }

    @BeforeMethod(description = "Initialization of class fields and driver's configurations")
    public void initBrowser() {
        homeUrl = "https://jdi-testing.github.io/jdi-light/index.html";
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        actionStep = new ActionStep(driver);
        assertStep = new AssertStep(driver);
        properties = new Properties();
        try {
            properties.load(new FileReader("src/test/resources/data.properties"));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Step("Check that title is '{expTitle}' and authorization of user '{userData.name}'")
    public void authorization(UserData userData, String expTitle) {
        //1. Open test site by URL
        actionStep.openSite(homeUrl);

        //2. Assert Browser title
        assertStep.checkTitle(expTitle);

        //3. Perform login
        actionStep.authorization(userData.getLogin(), userData.getPassword());

        //4. Assert Username is loggined
        assertStep.checkUser(userData.getName());
    }

    //ex.1 12. Close Browser
    //ex.2 10. Close Browser
    @AfterMethod(description = "Finish browser's work")
    public void closeBrowser() {
        actionStep.quitBrowser();
    }
}
