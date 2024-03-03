package com.juaracoding.drivers.strategies;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Firefox implements DriverStrategy{

    @Override
    public WebDriver setStrategy() {
        String path = "/Users/macbookpro/Downloads/driver/geckodriver";
        System.setProperty("webdriver.gecko.driver",path);
        return new FirefoxDriver();
    }
}
