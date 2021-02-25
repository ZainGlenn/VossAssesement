package com.voss.automation.loginautomation;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import com.thoughtworks.gauge.Step;
import com.voss.helpers.CaptureSolver;
import com.voss.util.TestUtil;

public class WebSteps {
    private final WebObjects webObjects = new WebObjects();

    @Step("Validate login page is displayed")
    public void validateLoginPageIsDisplayed() {
        webObjects.getWelcomeBackHeader().waitForPageElement().appearedOnPage();
        webObjects.getEmailText().waitForPageElement().appearedOnPage();
        webObjects.getPasswordText().waitForPageElement().appearedOnPage();
        webObjects.getSignButton().waitForPageElement().appearedOnPage();
    }

    @Step("Enter email <email> and password <password>")
    public void enterEmailAndPassword(String email, String password) {
        webObjects.getEmailText().waitForPageElement().enterText(email);
        webObjects.getPasswordText().waitForPageElement().enterText(password);

    }

    @Step("Click 'Sign In' button")
    public void clickSignInButton() {
        webObjects.getSignButton().waitForPageElement().click();
    }

    @Step("Validate home page is displayed for user <username>")
    public void validateHomePageIsDisplayed(String username) {
        webObjects.getProfileDropdown().waitForPageElement().appearedOnPage();
        webObjects.getUserText().waitForPageElement().andContainsText(username);
        webObjects.getMyDashboardButton().waitForPageElement().appearedOnPage();
    }

    @Step("Logout")
    public void clickLogout() {
        webObjects.getProfileDropdown().waitForPageElement().click();
        webObjects.getSignButton().waitForPageElement().click();
    }

    @Step("Solve capture problem")
    public void solveCaptureProblem() {
        String url = WebDriverRunner.url();
        CaptureSolver captureSolver = new CaptureSolver(TestUtil.getInstance(), url);
        String id = captureSolver.solve();
        Selenide.executeJavaScript("document.getElementById('g-recaptcha-response').setAttribute('value', '" + id + "')");
    }
}
