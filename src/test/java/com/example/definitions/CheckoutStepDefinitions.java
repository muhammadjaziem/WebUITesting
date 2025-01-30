package com.example.definitions;

import com.example.pages.InventoryPage;
import com.example.pages.CartPage;
import com.example.pages.CheckoutPage;
import com.example.pages.LoginPage;
import io.cucumber.java.en.*;
import org.testng.Assert;

public class CheckoutStepDefinitions {
    private LoginPage loginPage;
    private InventoryPage inventoryPage;
    private CartPage cartPage;
    private CheckoutPage checkoutPage;

    public CheckoutStepDefinitions() {
        loginPage = new LoginPage();
        inventoryPage = new InventoryPage();
        cartPage = new CartPage();
        checkoutPage = new CheckoutPage();
    }

    @When("I add an item to the cart")
    public void iAddAnItemToTheCart() {
        inventoryPage.addItemToCart();
    }

    @And("I go to the cart page")
    public void iGoToTheCartPage() {
       inventoryPage.goToCart();
    }

    @And("I proceed to checkout with first name {string}, last name {string}, and postal code {string}")
    public void iProceedToCheckoutWithDetails(String firstName, String lastName, String postalCode) {
       checkoutPage = inventoryPage.checkout();
       checkoutPage.enterCheckoutDetails(firstName, lastName, postalCode);
       checkoutPage.completeCheckout();
    }

    @Then("I should see the checkout complete message")
    public void iShouldSeeTheCheckoutCompleteMessage() {
        Assert.assertEquals(checkoutPage.isCheckoutComplete(), "Checkout: Complete!");
    }
}
