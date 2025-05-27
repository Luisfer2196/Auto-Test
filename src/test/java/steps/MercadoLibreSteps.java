package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import pages.MeliPage;

public class MercadoLibreSteps {
    MeliPage me=new MeliPage();



    @Given("I navigate to MercadoLibre site")
    public void iNavigateToMercadoLibreSite() {
        me.goToSite();
    }

    @And("click on Categorías")
    public void clickOnCategorias() {
        me.clickCategories();

    }

    @And("click on Makes dropdown")
    public void clickOnMakesDropdown() throws InterruptedException {
        me.clickDropdown();
    }

    @Then("I can see the total of {int} car makes")
    public void iCanSeeAllTheCarMakes(int expectedNumber) {
        Assertions.assertEquals(expectedNumber,me.carMakes().size());
    }

    @When("click on vehiculos option")
    public void clickOnVehiculosOption() {
        me.clickVehiculos();
    }

    @When("I click on {word}")
    public void iClickOnMake(String make) throws InterruptedException {
        me.clickMake(make);
    }


    @And("click on search")
    public void clickOnSearch() {
        me.clickSearch();
    }

    @Then("I can see the {word} of results")
    public void iCanSeeTheAmountOfResults(String amount) {
        //Assertions.assertEquals(amount+" resultados",me.resultados());
        Assertions.assertTrue(me.resultados().contains(amount+" resultados"));
    }
}
