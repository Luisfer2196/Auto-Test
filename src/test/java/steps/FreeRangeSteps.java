package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;
import pages.CursosPage;
import pages.FundamentosPage;
import pages.PaginaPrincipal;
import pages.RegistroPage;

import java.util.List;


public class FreeRangeSteps {
    SoftAssert soft=new SoftAssert();

    PaginaPrincipal landingPage=new PaginaPrincipal();
    CursosPage cursosPage= new CursosPage();
    FundamentosPage fpage=new FundamentosPage();
    RegistroPage registro=new RegistroPage();



    @Given("^(?:I|The user) navigate[s]? to www.freerangertesters.com")
    public void iNavigateToWwwFreerangertestersCom() {
        landingPage.navigateToFreeRange();
    }

    @When("I go to a {word} in the nav bar")
    public void iGoToASectionInTheNavBar(String section) {
        landingPage.clickNavSection(section);
    }

    @And("select Introduccion al Testing")
    public void selectIntroduccionAlTesting() {
        cursosPage.clickFundamentos();

    }

    @And("click on Comprar ahora")
    public void clickOnComprarAhora() {
        fpage.clickComprar();
    }

    @When("I select Elegir Plan")
    public void iSelectElegirPlan() {
        landingPage.clickElegirPlan();
    }

    @Then("I can validate the options in the checkout page")
    public void iCanValidateTheOptionsInTheCheckoutPage() {
        List<String> lista= registro.returnDrodpownnValues();
        List<String> listaEsperada=List.of("Academia: $16.99 / mes • 14 productos","Academia: $176 / año • 14 productos",
                "Free: Gratis • 3 productos");

        Assert.assertEquals(lista,listaEsperada);



    }
    //soft assertion
//    public void testSoftAssert(){
//        List<String> lista= List.of("Academia: $16.99 / mes • 14 productos","Academia: $176 / año • 14 productos",
//                "Free: Gratis • 3 productos");
//        List<String> listaEsperada=List.of("Academia: $16.99 / mes • 14 productos","Academia: $176 / año • 14 productos",
//                "Free: Gratis • 3 productos");
//        soft.assertTrue(lista.getFirst().contains(listaEsperada.getFirst()));
//        soft.assertEquals(lista,listaEsperada);
//        soft.assertAll();
//    }



    @Then("I should see the course that I'm about to buy")
    public void iShouldSeeTheCourseThatIMAboutToBuy() {
        Assert.assertTrue(registro.courseTitle("Introducción al Testing de Software"));
    }

    @Then("I am redirected to the right {word}")
    public void iAmRedirectedToTheRightSection(String section) {
        Assert.assertTrue(cursosPage.tabTitle(section));
    }


}
