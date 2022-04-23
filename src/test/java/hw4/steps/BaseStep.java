package hw4.steps;

import hw3.pages.DifferentElements;
import hw3.pages.HomePage;
import org.openqa.selenium.WebDriver;

public class BaseStep {

    protected WebDriver driver;

    protected HomePage homePage;
    protected DifferentElements diffElem;

    public BaseStep(WebDriver driver) {
        this.driver = driver;
        homePage = new HomePage(driver);
        diffElem = new DifferentElements(driver);
    }
}
