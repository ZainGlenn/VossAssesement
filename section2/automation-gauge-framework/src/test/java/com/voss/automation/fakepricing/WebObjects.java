package com.voss.automation.fakepricing;

import com.voss.util.components.WebAutomationObject;
import org.openqa.selenium.By;

class WebObjects {
    private final WebAutomationObject pricingHeading = new WebAutomationObject(By.xpath("//*[@class = 'et_pb_text_inner']/h1"));

    public WebAutomationObject getPricingHeading() {
        return pricingHeading;
    }

    public WebAutomationObject getPackagePricing(String name, String price){
        return new WebAutomationObject(By.xpath("//h4[text() = '"+name+"']/ancestor::div[@class = 'et_pb_pricing_table_wrap']//span[text() = '"+price+"']"));
    }

    public WebAutomationObject getPurchaseButton(String name){
        return new WebAutomationObject(By.xpath("//h4[text() = '"+name+"']/ancestor::div[@class = 'et_pb_pricing_table_wrap']//a[text() = 'Purchase']"));
    }
}
