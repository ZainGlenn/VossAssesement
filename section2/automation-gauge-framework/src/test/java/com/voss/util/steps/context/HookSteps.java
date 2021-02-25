package com.voss.util.steps.context;

import com.codeborne.selenide.Configuration;
import com.thoughtworks.gauge.BeforeScenario;
import com.voss.util.BrowserSettings;
import com.voss.util.TestUtil;
import org.junit.jupiter.api.Assertions;

public class HookSteps {
    @BeforeScenario
    public void BeforeScenario() {
        TestUtil testUtil = TestUtil.getInstance();
        String browserType = testUtil.getBrowserType();
        if (browserType.equals("chrome")) {
            new BrowserSettings().setSelenoid()
                    .setDefaultDesiredCapabilities()
                    .setChromeOptions(false, false)
                    .setWindowSize();
        } else if (browserType.equals("firefox")) {
            System.out.println("running firefox");
            Configuration.browser="firefox";
        } else {
            Assertions.fail("Unknown browser type - " + browserType);
        }

    }
}
