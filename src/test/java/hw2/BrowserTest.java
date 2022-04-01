package hw2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class BrowserTest {
    protected WebDriver driver;
    protected SoftAssert softAssert;
    protected String homeUrl;

    @BeforeClass
    public void initBrowser() {
        softAssert = new SoftAssert();
        homeUrl = "https://jdi-testing.github.io/jdi-light/index.html";
        String path = "src/main/resources/chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", path);
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    public void authorization() {
        //1. Open test site by URL
        driver.get(homeUrl);

        //2. Assert Browser title
        String actualTitle = driver.getTitle();
        softAssert.assertEquals(actualTitle, "Home Page");

        //3. Perform login
        driver.findElement(By.cssSelector(".uui-profile-menu .dropdown-toggle")).click();
        WebElement name = driver.findElement(By.id("name"));
        WebElement password = driver.findElement(By.id("password"));
        name.sendKeys("Roman");
        password.sendKeys("Jdi1234");
        WebElement loginButton = driver.findElement(By.id("login-button"));
        loginButton.click();

        //4. Assert Username is loggined
        WebElement userName = driver.findElement(By.id("user-name"));
        softAssert.assertTrue(userName.isDisplayed());
        softAssert.assertEquals(userName.getText(), "ROMAN IOVLEV");
    }

    @AfterClass
    //ex.1 12. Close Browser
    //ex.2 10. Close Browser
    public void closeBrowser() {
        driver.quit();
    }
}
