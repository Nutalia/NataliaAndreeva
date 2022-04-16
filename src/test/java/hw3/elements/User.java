package hw3.elements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class User {
    @FindBy(css = ".uui-profile-menu .dropdown-toggle")
    WebElement userIcon;
    @FindBy(id = "name")
    WebElement login;
    @FindBy(id = "password")
    WebElement password;
    @FindBy(id = "login-button")
    WebElement button;
    @FindBy(id = "user-name")
    WebElement userName;

    public void authorization(String login, String password) {
        userIcon.click();
        this.login.sendKeys(login);
        this.password.sendKeys(password);
        button.click();
    }

    public String getUserName() {
        return userName.getText();
    }

    public User(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
}
