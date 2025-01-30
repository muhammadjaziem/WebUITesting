package com.example.pages;

import com.example.utils.HelperClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {

    WebDriverWait wait;
    @FindBy(id="user-name")
    public WebElement usernameField;

    @FindBy(id="password")
    public WebElement passwordField;

    @FindBy(id="login-button")
    public WebElement loginButton;

    @FindBy(css="[data-test='error']")
    public WebElement errorMessage;


   public LoginPage()
   {
       PageFactory.initElements(HelperClass.getDriver(),this);
   }

   public void openPage(String url)
   {
       HelperClass.getDriver().get(url);
   }

    public void enterUsername(String username) {
        usernameField.sendKeys(username);
    }

    public void enterPassword(String password) {
       passwordField.sendKeys(password);
    }

    public void clickLogin() {
        loginButton.click();
    }

    public String getErrorMessage() {
        return errorMessage.getText();
    }
}
