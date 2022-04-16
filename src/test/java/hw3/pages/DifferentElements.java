package hw3.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class DifferentElements {

    @FindBy(css = "label.label-checkbox")
    List<WebElement> checkBoxes;
    @FindBy(css = "label.label-radio")
    List<WebElement> radioButtons;
    @FindBy(tagName = "option")
    List<WebElement> dropdown;
    @FindBy(css = ".info-panel-body-log li")
    List<WebElement> logs;

    public DifferentElements(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void clickCheckBox(String textCheckBox) {
        for (WebElement box : checkBoxes) {
            if (box.getText().equals(textCheckBox)) {
                box.click();
                return;
            }
        }
    }

    public void clickRadioButton(String textRadioButton) {
        for (WebElement radio : radioButtons) {
            if (radio.getText().equals(textRadioButton)) {
                radio.click();
                return;
            }
        }
    }

    public void clickDropdown(String textDropdown) {
        for (WebElement option : dropdown) {
            if (option.getText().equals(textDropdown)) {
                option.click();
                return;
            }
        }
    }

    public List<WebElement> getLogs() {
        return logs;
    }
}
