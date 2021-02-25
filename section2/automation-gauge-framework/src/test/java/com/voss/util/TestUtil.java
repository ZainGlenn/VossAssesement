package com.voss.util;

import com.voss.exception.AutomationTestRuntimeException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.Objects;
import java.util.Properties;

public class TestUtil {

    private static final String COMMON_PROPERTIES_FILE_NAME = "common.properties";
    protected final Logger log = LoggerFactory.getLogger(this.getClass());
    private final Properties properties = new Properties();

    private TestUtil() {
        try {
            properties.putAll(loadProperties(getPropertiesFileName()));
            properties.putAll(loadSystemProperties());
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw new AutomationTestRuntimeException(e.getMessage(), e);
        }
    }

    public static TestUtil getInstance() {
        return SingletonHolder.INSTANCE;
    }

    private Properties loadProperties(String propertiesFile) throws IOException {
        log.info("Loading properties for: [" + propertiesFile + "].");
        Properties properties = new Properties();
        InputStream resourceAsStream = TestUtil.class.getClassLoader().getResourceAsStream(propertiesFile);
        properties.load(Objects.requireNonNull(resourceAsStream));
        return properties;
    }

    private Properties loadSystemProperties() throws IOException {
        log.info("Loading system properties:");
        Properties properties = System.getProperties();
        return properties;
    }

    private String getPropertiesFileName() {
        String propertiesFile = System.getProperty("env.properties");
        if (propertiesFile == null) {
            propertiesFile = "default";
        }
        propertiesFile = propertiesFile + ".properties";
        return propertiesFile;
    }

    public String getProperty(String propertyName) {
        return properties.getProperty(propertyName,null);
    }

    public String getLocale() {
        return properties.getProperty("browser.localisation", "en");
    }

    public boolean isSelenoid() {
        String selenoid = properties.getProperty("use.selenoid", "true");
        return Boolean.parseBoolean(selenoid);
    }

    public boolean isJenkins() {
        String jenkins = properties.getProperty("jenkins.headless", "false");
        return Boolean.parseBoolean(jenkins);
    }

    public boolean isHolderBrowserOpen() {
        String jenkins = properties.getProperty("browser.open", "false");
        return Boolean.parseBoolean(jenkins);
    }

    public boolean isStage4() {
        String serverName = properties.getProperty("server.name");
        return serverName.contains("stage-04");
    }

    public boolean isStage5() {
        String serverName = properties.getProperty("server.name");
        return serverName.contains("stage-05");
    }

    public boolean isTeam03() {
        String serverName = properties.getProperty("server.name");
        return serverName.contains("team-03");
    }

    public boolean isRemote() {
        String isRemote = properties.getProperty("browser.isRemote", "false");
        return Boolean.parseBoolean(isRemote);
    }

    public String remoteUrl() {
        return properties.getProperty("browser.remoteUrl", null);
    }

    public String getUrl() {
        String url = properties.getProperty("server.url", null);
        if (Objects.isNull(url)) {
            throw new AutomationTestRuntimeException("server.url needs to be defined in resource file", new Throwable());
        }
        return url;
    }

    public String getBrowserType() {
        return properties.getProperty("browser.type", "chrome");
    }

    private String capitalize(String str) {
        if (str == null) return str;
        return str.substring(0, 1).toUpperCase() + str.substring(1);
    }

    private static class SingletonHolder {
        public static final TestUtil INSTANCE = new TestUtil();
    }


}
