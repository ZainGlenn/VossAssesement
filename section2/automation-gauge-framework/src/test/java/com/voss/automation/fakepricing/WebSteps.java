package com.voss.automation.fakepricing;

import com.thoughtworks.gauge.Step;

public class WebSteps {
    private final WebObjects webObjects = new WebObjects();
    @Step("Validate Fake pricing page is open")
    public void validateFakePricingPageIsOpen() {
        webObjects.getPricingHeading()
                .waitForPageElement()
                .andExactText("Pick a Plan that Works for Your Business Model");
    }

    @Step("Validate package <Basic> is valued at <price>/month")
    public void validatePackage(String name, String price) {
        webObjects.getPackagePricing(name,price)
                .waitForPageElement()
                .appearedOnPage();
    }

    @Step("Click purchase on package tier named - <Basic>")
    public void clickPurchase(String name) {
        webObjects.getPurchaseButton(name)
                .waitForPageElement()
                .click();
    }
}
