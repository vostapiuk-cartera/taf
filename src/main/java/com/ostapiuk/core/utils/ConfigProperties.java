package com.ostapiuk.core.utils;

import java.util.Objects;

import static com.ostapiuk.core.utils.PropertySource.getProperty;

public class ConfigProperties {

    private ConfigProperties() {
        throw new IllegalStateException("Utility class");
    }

    public static String getDriverProperty() {
        return getProperty("driver");
    }

    public static int getImplicitWaitProperty() {
        return Integer.parseInt(Objects.requireNonNull(getProperty("implicit_wait")));
    }

    public static int getPageLoadWaitProperty() {
        return Integer.parseInt(Objects.requireNonNull(getProperty("page_load_wait")));
    }

    public static int getExplicitWait() {
        return Integer.parseInt(Objects.requireNonNull(getProperty("explicit_wait")));
    }

    public static String getExpectedTitleProperty() {
        return getProperty("expected_title");
    }

    public static String getBaseUrlProperty() {
        return getProperty("base_url");
    }

    public static String getExpectedPremiumUrlProperty() {
        return getProperty("expected_premium_url");
    }
}
