package com.voss.util.steps;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import com.thoughtworks.gauge.Gauge;
import com.thoughtworks.gauge.GaugeConstant;
import com.thoughtworks.gauge.Step;
import com.voss.util.Utils;
import org.apache.commons.io.IOUtils;
import org.junit.jupiter.api.Assertions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.back;

public class UtilitySteps {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Step({"Sleep forever"})
    public void sleepForever() {
        logger.info("starting sleep forever");
        Utils.sleepForever();
    }

    @Step({"Go Back"})
    public void goBack() {
        back();
    }

    @Step({"Shut down browser"})
    public void shutDownBrowser() {
        WebDriverRunner.driver().close();
    }

    @Step("Take a screenshot with the name <pictureName>.")
    public void takesScreenshot(String pictureName) throws IOException {
        String screenshotPath = Selenide.screenshot(String.format("%s-%d", pictureName, System.currentTimeMillis()));
        Gauge.writeMessage("XScreenshotPath: " + screenshotPath);
        assert screenshotPath != null;
        File screenshotFile = new File(screenshotPath);
        File gaugeScreenshotFile = gaugeScreenshotFile(screenshotFile.getName());
        IOUtils.copy(new FileInputStream(screenshotFile), new FileOutputStream(gaugeScreenshotFile));
    }

    private File gaugeScreenshotFile(String fileName) {
        Path path = Paths.get(System.getenv(GaugeConstant.SCREENSHOTS_DIR_ENV), fileName);
        return new File(path.toAbsolutePath().toString());
    }

    @Step("Maximize browser")
    public void maximizeBrowser() {
        WebDriverRunner.getWebDriver().manage().window().maximize();
    }

    @Step("Fail test - <name>")
    public void failTest(String name) {
        Assertions.fail(name);
    }

    @Step("Validate Page title is <name>")
    public void validatePageTitle(String name) {
        $("title").shouldHave(attribute("text", name));
    }
}
