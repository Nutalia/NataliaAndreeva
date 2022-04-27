package hw5.steps;

import hw3.pages.DifferentElements;
import hw3.pages.HomePage;
import hw5.context.TestContext;
import hw5.elements.UserTable;
import org.openqa.selenium.WebDriver;

public class BaseStep {
    protected WebDriver driver;
    protected HomePage homePage;
    protected DifferentElements diffElem;
    protected UserTable userTable;

    public BaseStep() {
        this.driver = TestContext.getInstance().getTestObject("driver");
        homePage = new HomePage(driver);
        diffElem = new DifferentElements(driver);
        userTable = new UserTable(driver);
    }
}
