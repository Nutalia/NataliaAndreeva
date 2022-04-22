package hw4.steps;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ActionStep extends BaseStep{

    public ActionStep(WebDriver driver) {
        super(driver);
    }

    public WebDriver getDriver() {
        return driver;
    }

    @Step(value = "Open the site's home page")
    public void openSite(String url) {
        driver.get(url);
    }

    @Step(value = "Log in with login: {login}; password: {password}")
    public void authorization(String login, String password) {
        homePage.getUser().authorization(login, password);
    }

    @Step(value = "Switch to parent page")
    public void switchBack() {
        driver.switchTo().parentFrame();
    }

    @Step("Open page by SERVICE -> {subitem}")
    public void clickServiceItem(String subitem) {
        homePage.getHeaderMenu().getSubitemByText("SERVICE", subitem).click();
    }

    @Step("Select checkbox {checkName}")
    public void selectCheckBox(String checkName) {
        diffElem.clickCheckBox(checkName);
    }

    @Step("Select radio button {radioName}")
    public void selectRadio(String radioName) {
        diffElem.clickRadioButton(radioName);
    }

    @Step("Select {color} color")
    public void selectColor(String color) {
        diffElem.clickDropdown(color);
    }

    @Step(value = "Close Browser")
    public void quitBrowser() {
        driver.quit();
    }
}
