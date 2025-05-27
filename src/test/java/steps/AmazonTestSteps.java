package steps;

import io.cucumber.java.en.*;
import org.junit.Assert;
import pages.AmazonPage;

public class AmazonTestSteps {
    AmazonPage ap=new AmazonPage();

    @Given("User goes to www.amazon.com")
    public void userIsAbleToGoToWwwAmazonCom() {
        ap.navigateTo();
    }

    @When("They search for {word}")
    public void iSearchForProduct(String product) {
        ap.searchProduct(product);
        ap.clickOnSearchButton();
    }

    @And("navigate to the page number {int}")
    public void navigatesToPage(int pageNumber) {
        ap.goToPage(pageNumber);
    }

    @And("select the item {int}")
    public void selectsTheThirdItem(int item) {
        ap.clickItem(item);
    }

    @Then("the user should be able to add the product to the cart")
    public void theUserShouldBeAbleToAddTheProductToTheCart() {
        ap.addToCart();
        Assert.assertEquals("Added to cart", ap.successMessage());
    }
}
