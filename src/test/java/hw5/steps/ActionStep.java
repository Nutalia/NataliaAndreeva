package hw5.steps;

import io.cucumber.java.en.When;

public class ActionStep extends BaseStep {

    @When("User switches back to parent window")
    public void switchBack() {
        driver.switchTo().parentFrame();
    }

    @When("User clicks on {string} in Header Menu->Service")
    public void clickServiceItem(String subitem) {
        homePage.getHeaderMenu().getSubitemByText("SERVICE", subitem).click();
    }

    @When("User choose checkbox {string}")
    public void selectCheckBox(String checkName) {
        diffElem.clickCheckBox(checkName);
    }

    @When("User choose radio button {string}")
    public void selectRadio(String radioName) {
        diffElem.clickRadioButton(radioName);
    }

    @When("User choose {string} in dropdown")
    public void selectColor(String color) {
        diffElem.clickDropdown(color);
    }

    @When("User selects 'vip' checkbox for {string}")
    public void selectCheckboxByUserName(String name) {
        userTable.clickCheckboxByUserName(name);
    }
}
