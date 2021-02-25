package com.voss.helpers;

import com.twocaptcha.TwoCaptcha;
import com.twocaptcha.captcha.ReCaptcha;
import com.voss.exception.AutomationTestRuntimeException;
import com.voss.util.TestUtil;

import java.util.Objects;

public class CaptureSolver {
    private final String apiKey;
    private final String siteKey;
    private final String url;

    public CaptureSolver(TestUtil testUtil, String url) {
        this.apiKey = testUtil.getProperty("capture.api.key");
        if (Objects.isNull(apiKey)) {
            throw new AutomationTestRuntimeException("Cannot solve capture without api key present in resources", new Throwable());
        }
        this.siteKey = testUtil.getProperty("capture.site.key");
        this.url = url;
    }

    public String solve() {
        TwoCaptcha solver = new TwoCaptcha(apiKey);

        ReCaptcha captcha = new ReCaptcha();
        captcha.setSiteKey(siteKey);
        captcha.setUrl(url);

        try {
            solver.solve(captcha);
            return captcha.getCode();
        } catch (Exception e) {
            throw new AutomationTestRuntimeException(e.getMessage(), new Throwable());
        }
    }
}
