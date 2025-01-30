package com.example.definitions;

import com.example.pages.LoginPage;
import com.example.utils.HelperClass;
import io.cucumber.java.en.*;
import org.testng.Assert;

public class LoginStepDefinitions {
    private final LoginPage loginPage = new LoginPage();

    @Given("I open the login page {string}")
    public void iOpenTheLoginPage(String url) {
        loginPage.openPage(url);
    }

    @When("I enter {string} as username and {string} as password")
    public void iEnterCredentials(String username, String password) {
        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
        loginPage.clickLogin();
    }

    @Then("I should be redirected to the products page")
    public void iShouldBeRedirectedToTheProductsPage() {
        Assert.assertEquals(HelperClass.getDriver().getTitle(), "Swag Labs");
    }

    @Then("I should see an error message {string}")
    public void iShouldSeeAnErrorMessage(String expectedMessage) {
        Assert.assertTrue(loginPage.getErrorMessage().contains(expectedMessage));
    }
}
