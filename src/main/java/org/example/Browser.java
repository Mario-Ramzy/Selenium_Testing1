package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Browser {
    public static WebDriver driver;

    public static void startBrowser(){
        driver = new FirefoxDriver();
    }
}
