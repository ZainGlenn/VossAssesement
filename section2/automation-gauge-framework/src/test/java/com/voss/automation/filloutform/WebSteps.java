package com.voss.automation.filloutform;

import com.thoughtworks.gauge.Step;
import com.thoughtworks.gauge.Table;
import com.voss.util.Utils;
import com.voss.util.components.GaugeTable;

public class WebSteps {
    private final WebObjects webObjects = new WebObjects();

    @Step("Complete form on left <table>")
    public void completeFormOnLeft(Table table) {
        GaugeTable gaugeTable = new GaugeTable(table);
        String name = gaugeTable.getValue("name");
        String message = gaugeTable.getValue("message");
        webObjects.getNameLeftText()
                .waitForPageElement()
                .enterText(name);
        webObjects.getMessageLeftText()
                .waitForPageElement()
                .enterText(message);
    }

    @Step("Complete form on right <table>")
    public void completeFormOnRight(Table table) {
        GaugeTable gaugeTable = new GaugeTable(table);
        String name = gaugeTable.getValue("name");
        String message = gaugeTable.getValue("message");
        webObjects.getNameRightText()
                .waitForPageElement()
                .enterText(name);
        webObjects.getMessageRightText()
                .waitForPageElement()
                .enterText(message);
    }

    @Step("Solve math problem")
    public void solveMathProblem() {
        String mathProblem = webObjects.getMathProblem()
                .waitForPageElement()
                .getElementText();
        int value = Utils.solveMathProblem(mathProblem);
        webObjects.getMathProblemText()
                .waitForPageElement()
                .enterText(String.valueOf(value));
    }

    @Step("Click Submit on left form")
    public void clickSubmitLeft() {
        webObjects.getSubmitLeft()
                .waitForPageElement()
                .click();
    }

    @Step("Click Submit on right form")
    public void clickSubmitRight() {
        webObjects.getSubmitRight()
                .waitForPageElement()
                .click();
    }

    @Step("Validate left form fails to submit")
    public void validateLeftForm() {
       webObjects.getLeftFormError()
               .waitForPageElement()
               .andExactText("Please refresh the page and try again.");
    }

    @Step("Validate right form fails to submit")
    public void validateRightForm() {
        webObjects.getRightFormError()
                .waitForPageElement()
                .andExactText("Please refresh the page and try again.");
    }

    @Step("Validate name and message is required field on right form")
    public void validateRightFormRequiredFields() {
        webObjects.getRequiredFieldRight()
                .waitForPageElement()
                .andContainsText("Please, fill in the following fields")
                .andContainsText("Name")
                .andContainsText("Message");
    }

    @Step("Validate name and message is required field on left form")
    public void validateLeftFormRequiredFields() {
        webObjects.getRequiredFieldLeft()
                .waitForPageElement()
                .andContainsText("Please, fill in the following fields")
                .andContainsText("Name")
                .andContainsText("Message");
    }


}
