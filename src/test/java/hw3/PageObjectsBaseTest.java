package hw3;

import hw3.elements.User;
import hw3.pages.HomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.asserts.SoftAssert;

import java.io.FileReader;
import java.time.Duration;
import java.util.Properties;

public class PageObjectsBaseTest {
    protected WebDriver driver;
    protected String homeUrl;
    protected SoftAssert softAssert;
    protected HomePage homePage;
    protected Properties properties;

    @BeforeSuite
    public void initSystem() {
        String path = "src/main/resources/chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", path);
    }

    @BeforeMethod
    public void initBrowser() {
        homeUrl = "https://jdi-testing.github.io/jdi-light/index.html";
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        softAssert = new SoftAssert();
        homePage = new HomePage(driver);
        properties = new Properties();
        try {
            properties.load(new FileReader("src/test/resources/data.properties"));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void authorization(UserData userData, String expTitle) {
        //1. Open test site by URL
        driver.get(homeUrl);

        //2. Assert Browser title
        softAssert.assertEquals(driver.getTitle(), expTitle);

        //3. Perform login
        User user = homePage.getUser();
        user.authorization(userData.getLogin(), userData.getPassword());

        //4. Assert Username is loggined
        softAssert.assertEquals(user.getUserName(), userData.getName());
    }

    //ex.1 12. Close Browser
    //ex.2 10. Close Browser
    @AfterMethod
    public void closeBrowser() {
        driver.quit();
    }
}
