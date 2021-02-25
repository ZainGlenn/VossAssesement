package com.voss.automation.filloutform;

import com.voss.util.components.WebAutomationObject;
import org.openqa.selenium.By;

class WebObjects {
    private final WebAutomationObject nameLeftText = new WebAutomationObject(By.id("et_pb_contact_name_0"));
    private final WebAutomationObject nameRightText = new WebAutomationObject(By.id("et_pb_contact_name_1"));
    private final WebAutomationObject messageLeftText = new WebAutomationObject(By.id("et_pb_contact_message_0"));
    private final WebAutomationObject messageRightText = new WebAutomationObject(By.id("et_pb_contact_message_1"));
    private final WebAutomationObject mathProblem = new WebAutomationObject(By.className("et_pb_contact_captcha_question"));
    private final WebAutomationObject mathProblemText = new WebAutomationObject(By.xpath("//*[@name = 'et_pb_contact_captcha_1']"));
    private final WebAutomationObject submitLeft = new WebAutomationObject(By.xpath("//*[@id = 'et_pb_contact_form_0']//button[@name = 'et_builder_submit_button']"));
    private final WebAutomationObject submitRight = new WebAutomationObject(By.xpath("//*[@id = 'et_pb_contact_form_1']//button[@name = 'et_builder_submit_button']"));
    private final WebAutomationObject leftFormError = new WebAutomationObject(By.xpath("//*[@id = 'et_pb_contact_form_0']//*[@class = 'et_pb_contact_error_text']"));
    private final WebAutomationObject rightFormError = new WebAutomationObject(By.xpath("//*[@id = 'et_pb_contact_form_1']//*[@class = 'et_pb_contact_error_text']"));
    private final WebAutomationObject requiredFieldLeft = new WebAutomationObject(By.xpath("//*[@id = 'et_pb_contact_form_0']//*[@class = 'et-pb-contact-message']"));
    private final WebAutomationObject requiredFieldRight = new WebAutomationObject(By.xpath("//*[@id = 'et_pb_contact_form_1']//*[@class = 'et-pb-contact-message']"));

    public WebAutomationObject getRequiredFieldLeft() {
        return requiredFieldLeft;
    }

    public WebAutomationObject getRequiredFieldRight() {
        return requiredFieldRight;
    }

    public WebAutomationObject getLeftFormError() {
        return leftFormError;
    }

    public WebAutomationObject getRightFormError() {
        return rightFormError;
    }

    public WebAutomationObject getNameLeftText() {
        return nameLeftText;
    }

    public WebAutomationObject getNameRightText() {
        return nameRightText;
    }

    public WebAutomationObject getMessageLeftText() {
        return messageLeftText;
    }

    public WebAutomationObject getMessageRightText() {
        return messageRightText;
    }

    public WebAutomationObject getMathProblem() {
        return mathProblem;
    }

    public WebAutomationObject getMathProblemText() {
        return mathProblemText;
    }

    public WebAutomationObject getSubmitLeft() {
        return submitLeft;
    }

    public WebAutomationObject getSubmitRight() {
        return submitRight;
    }
}
