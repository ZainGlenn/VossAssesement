package com.voss.automation.home;

import com.voss.util.components.WebAutomationObject;
import org.openqa.selenium.By;

class WebObjects {

    public WebAutomationObject getAutomationLink(String name){
        return new WebAutomationObject(By.xpath("//a[text() = '"+name+"']"));
    }
}
