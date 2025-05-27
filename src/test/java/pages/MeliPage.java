package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.logging.Logs;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class MeliPage extends BasePage{

    String dropLocator="//span[@id=':R1575h:-display-values']";//"(//div[@class='faceted-search-desktop__elem'])[2]"; //cssSelector #R1575h //"//button[@aria-label='Todas las marcas']";
    String dropdownContent="//ul[@id=':R1575h:-menu-list']//child::span";//"//span[contains(@class, 'andes-list__item-primary')]";
    String vehiculos="//a[normalize-space()='Vehículos']";
    String categorias="//a[normalize-space()='Categorías']";
    String makeTitle="//ul[@id=':R1575h:-menu-list']//span[text()='%s']";
    String buscarButton="//span[@class='andes-button__content']";
    String resultados="//span[@class='ui-search-search-result__quantity-results']";

    public void goToSite(){
        navigateTo("https://www.mercadolibre.com.co/");

    }

    public void clickCategories(){
        hoverOver(categorias);
    }

    public void clickDropdown() throws InterruptedException {
        Thread.sleep(500);
        clickElement(dropLocator);
    }

    public void clickVehiculos(){
        driver.findElement(By.xpath(vehiculos)).click();
    }


    public List<String> carMakes(){

        return getDropdownValues(dropdownContent);
        //return driver.findElements(By.xpath(dropdownContent)).stream().map(WebElement::getText).toList();

    }

    public void clickMake(String Make) throws InterruptedException {
        String make=String.format(makeTitle,Make);
        Thread.sleep(500);
        clickElement(make);
    }

    public void clickSearch(){
        clickElement(buscarButton);
    }

    public String resultados(){
        return getButtonName(resultados);
    }

}
