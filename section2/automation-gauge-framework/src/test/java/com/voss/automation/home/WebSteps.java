package com.voss.automation.home;

import com.thoughtworks.gauge.Step;
import com.voss.util.TestUtil;

import static com.codeborne.selenide.Selenide.open;

public class WebSteps {
    private final WebObjects webObjects = new WebObjects();
    @Step("User goes to ultimate qa page")
    public void launchURL() {
        TestUtil testUtil = TestUtil.getInstance();
        open(testUtil.getUrl());
    }

    @Step("Click <Login automation> link")
    public void clickLinkByName(String name) {
        webObjects.getAutomationLink(name)
                .waitForPageElement()
                .click();
    }
}
