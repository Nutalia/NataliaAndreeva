package hw5.steps;

import io.cucumber.java.en.Given;

public class ConditionStep extends BaseStep {

    @Given("User opens Home Page {string}")
    public void openSite(String url) {
        driver.get(url);
    }

    @Given("User logs in with login: {string} and password: {string}")
    public void authorization(String login, String password) {
        homePage.getUser().authorization(login, password);
    }
}
