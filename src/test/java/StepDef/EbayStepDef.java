package StepDef;


import Page.EbayPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class EbayStepDef {
    EbayPage page = new EbayPage();

    @Given("Browser is launched and url is opened")
    public void openBrowserAndLaunchUrl() {
        page.openBrowserAndLaunchUrl();
    }

    @And("Search for element")
    public void searchForElement() {
        page.searchForElement();
    }

    @And("Select the first option from list")
    public void selectElement() {
        page.selectElement();
    }

    @And("click on add to cart button")
    public void clickOnAddToCartButton() {
        page.addToCart();
    }

    @Then("verify cart has been updated")
    public void verifyCartHasBeenUpdated() {
        page.verifyCart();
    }

}