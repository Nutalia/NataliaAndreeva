package hw2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class BrowserTest {
    protected WebDriver driver;
    protected SoftAssert softAssert;
    protected String homeUrl;

    @BeforeSuite
    public void initSystem() {
        String path = "src/main/resources/chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", path);
    }

    @BeforeMethod
    public void initBrowser() {
        softAssert = new SoftAssert();
        homeUrl = "https://jdi-testing.github.io/jdi-light/index.html";
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    public void authorization(User user) {
        //1. Open test site by URL
        driver.get(homeUrl);

        //2. Assert Browser title
        softAssert.assertEquals(driver.getTitle(), "Home Page");

        //3. Perform login
        driver.findElement(By.cssSelector(".uui-profile-menu .dropdown-toggle")).click();
        driver.findElement(By.id("name")).sendKeys(user.getLogin());
        driver.findElement(By.id("password")).sendKeys(user.getPassword());
        driver.findElement(By.id("login-button")).click();

        //4. Assert Username is loggined
        WebElement userName = driver.findElement(By.id("user-name"));
        softAssert.assertTrue(userName.isDisplayed());
        softAssert.assertEquals(userName.getText(), user.getName());
    }

    //ex.1 12. Close Browser
    //ex.2 10. Close Browser
    @AfterMethod
    public void closeBrowser() {
        driver.quit();
    }
}
