package hw5.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class UserTable {

    @FindBy(css = "table select")
    List<WebElement> dropdowns;
    @FindBy(css = "table a")
    List<WebElement> names;
    @FindBy(css = "table .user-descr span")
    List<WebElement> descriptions;
    @FindBy(css = "table input")
    List<WebElement> checkboxes;
    @FindBy(css = "table tr")
    List<WebElement> tableLines;
    @FindBy(css = "div.info-panel-section")
    WebElement log;

    public UserTable(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public List<WebElement> getDropdowns() {
        return dropdowns;
    }

    public List<WebElement> getNames() {
        return names;
    }

    public List<WebElement> getDescriptions() {
        return descriptions;
    }

    public List<WebElement> getCheckboxes() {
        return checkboxes;
    }

    public List<String> getTableLineContent(int line) {
        List<String> result = new ArrayList<>();
        result.add(tableLines.get(line + 1).findElement(By.tagName("td")).getText());
        result.add(names.get(line).getText());
        result.add(descriptions.get(line).getText());
        return result;
    }

    public List<WebElement> getDropListValues(int line) {
        return dropdowns.get(line).findElements(By.tagName("option"));
    }

    public void clickCheckboxByUserName(String name) {
        for (int i = 0; i < 6; i++) {
            if (names.get(i).getText().equals(name)) {
                checkboxes.get(i).click();
                return;
            }
        }
    }

    public WebElement getLog() {
        return log;
    }
}
