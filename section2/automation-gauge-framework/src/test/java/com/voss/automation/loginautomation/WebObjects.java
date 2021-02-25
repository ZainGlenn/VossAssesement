package com.voss.automation.loginautomation;

import com.voss.util.components.WebAutomationObject;
import org.openqa.selenium.By;

class WebObjects {
    private final WebAutomationObject welcomeBackHeader = new WebAutomationObject(By.xpath("//h1[text() = 'Welcome Back!']"));
    private final WebAutomationObject emailText = new WebAutomationObject(By.xpath("//input[@type='email']"));
    private final WebAutomationObject passwordText = new WebAutomationObject(By.xpath("//input[@type='password']"));
    private final WebAutomationObject signButton = new WebAutomationObject(By.xpath("//*[@value='Sign in']"));

    private final WebAutomationObject profileDropdown = new WebAutomationObject(By.xpath("//*[@class = 'dropdown header__nav-item']"));
    private final WebAutomationObject myDashboardButton = new WebAutomationObject(By.xpath("//*[@class = 'header__nav-item']"));
    private final WebAutomationObject userText = new WebAutomationObject(By.xpath("//*[@class = 'dropdown header__nav-item']/a"));
    private final WebAutomationObject signOutListItem = new WebAutomationObject(By.xpath("//*[contains(text(), 'Sign Out')]"));


    public WebAutomationObject getUserText() {
        return userText;
    }

    public WebAutomationObject getMyDashboardButton() {
        return myDashboardButton;
    }

    public WebAutomationObject getProfileDropdown() {
        return profileDropdown;
    }

    public WebAutomationObject getSignOutListItem() {
        return signOutListItem;
    }

    public WebAutomationObject getWelcomeBackHeader() {
        return welcomeBackHeader;
    }

    public WebAutomationObject getEmailText() {
        return emailText;
    }

    public WebAutomationObject getPasswordText() {
        return passwordText;
    }

    public WebAutomationObject getSignButton() {
        return signButton;
    }
}
