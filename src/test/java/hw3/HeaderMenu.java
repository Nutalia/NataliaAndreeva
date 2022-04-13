package hw3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class HeaderMenu {
    @FindBy(css = "header .nav>li")
    List<WebElement> headerItems;

    public HeaderMenu(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public List<WebElement> getHeaderItems() {
        return headerItems;
    }

    public WebElement getItemByText(String itemText) {
        for (WebElement item : headerItems) {
            if (item.getText().equals(itemText))
                return item;
        }
        return null;
    }

    public WebElement getSubitemByText(String itemText, String subitemText) {
        WebElement item = getItemByText(itemText);
        item.click();
        List<WebElement> subitems = item.findElements(By.tagName("li"));
        for (WebElement sub : subitems) {
            if (sub.getText().equals(subitemText)) {
                return sub;
            }
        }
        return null;
    }
}
