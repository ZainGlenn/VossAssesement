package com.voss.util.components.table.model;

import com.codeborne.selenide.SelenideElement;
import com.voss.util.components.table.CustomValueParser;
import org.openqa.selenium.By;

public class PatientNameParser implements CustomValueParser {
    @Override
    public String transform(SelenideElement columnElement) {
        return columnElement.find(By.tagName("div"), 0).getText();
    }
}
