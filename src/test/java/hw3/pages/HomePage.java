package hw3.pages;

import hw3.elements.HeaderMenu;
import hw3.elements.LeftMenu;
import hw3.elements.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class HomePage {
    private HeaderMenu headerMenu;
    private User user;
    private LeftMenu leftMenu;
    private WebDriver driver;

    @FindBy(className = "benefit-icon")
    private List<WebElement> images;
    @FindBy(className = "benefit-txt")
    private List<WebElement> imageTexts;
    @FindBy(tagName = "iframe")
    private WebElement iframe;

    public HomePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
        headerMenu = new HeaderMenu(driver);
        user = new User(driver);
        leftMenu = new LeftMenu(driver);
    }

    public HeaderMenu getHeaderMenu() {
        return headerMenu;
    }

    public User getUser() {
        return user;
    }

    public LeftMenu getLeftMenu() {
        return leftMenu;
    }

    public List<WebElement> getImages() {
        return images;
    }

    public List<WebElement> getImageTexts() {
        return imageTexts;
    }

    public WebElement getIframe() {
        return iframe;
    }

    public WebElement getFrameButton() {
        driver.switchTo().frame(iframe);
        return driver.findElement(By.id("frame-button"));
    }
}
