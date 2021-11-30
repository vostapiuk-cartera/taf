package com.ostapiuk;

import com.ostapiuk.core.driver.DriverProvider;
import org.testng.annotations.AfterClass;

public class BaseTest {

    @AfterClass
    public void tearDown() {
        DriverProvider.quit();
    }
}
