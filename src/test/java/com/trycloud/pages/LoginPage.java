package com.trycloud.pages;

import com.trycloud.utilities.ConfigurationReader;
import com.trycloud.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class LoginPage {

    public LoginPage() {

        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//input[@name='user']")
    public WebElement usernameInput;

    @FindBy(xpath = "//input[@name='password']")
   public WebElement passwordInput;

    @FindBy(xpath = "//input[@id='submit-form']")
   public WebElement loginBtn;

    @FindBy(xpath = "//p[contains(text(),'Wrong username or password.')]")
   public WebElement errorMessage ;


    public void login(String username, String password) {
        usernameInput.clear();
        usernameInput.sendKeys(username);
        passwordInput.clear();
        passwordInput.sendKeys(password);
        loginBtn.click();
    }
    public void loginWithConfigurationProp() {
        usernameInput.clear();
        usernameInput.sendKeys(ConfigurationReader.getProperty("username1"));
        passwordInput.clear();
        passwordInput.sendKeys(ConfigurationReader.getProperty("password"));
        loginBtn.click();
    }


    }






