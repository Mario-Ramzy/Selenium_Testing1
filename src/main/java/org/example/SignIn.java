package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.*;
import static org.example.Browser.driver;

public class SignIn {
    //Sign in as Normal User
    public static void signInNormalUser(){
        Browser.startBrowser();

        driver.get("https://www.saucedemo.com/");
        By loginPageUserInputSelector = By.id("user-name");
        By loginPagePasswordInputSelector = By.id("password");
        By submitButtonSelector = By.id("login-button");
        WebElement usernameInput = driver.findElement(loginPageUserInputSelector);
        WebElement passwordInput = driver.findElement(loginPagePasswordInputSelector);
        WebElement submitButton = driver.findElement(submitButtonSelector);
        usernameInput.sendKeys("standard_user");
        passwordInput.sendKeys("secret_sauce");
        submitButton.click();
    }
    
}
