package pages;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.swing.*;
import java.awt.*;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class BasePage {

    protected static WebDriver driver;
    protected static WebDriverWait wait;
    protected static Actions action;

    static {
        WebDriverManager.chromedriver().setup();
        driver= new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        action= new Actions(driver);
    }

    private WebElement Find(String locator){
        return wait.until(ExpectedConditions.elementToBeClickable(By.xpath(locator)));
    }

    public static void navigateTo(String url){
        driver.get(url);
    }

    public void clickElement(String locator){
        Find(locator).click();
    }

    public void clickElementActions(String locator){
        action.moveToElement(Find(locator)).click().perform();
    }

    public static void closeBrowser(){
        driver.quit();
    }

    public void goToLinkText(String linkText){
        driver.findElement(By.linkText(linkText)).click();
    }

    public void hoverOver(String locator){
        action.moveToElement(Find(locator)).perform();
    }

    public void type(String locator, String keysToSend){
        Find(locator).clear();
        Find(locator).sendKeys(keysToSend);
    }

    public void selectFromDropdownByValue(String locator, String value){
        Select dropdown= new Select(Find(locator)); //Instancia clase tipo dropdown
        dropdown.selectByValue(value); //elegir/clickear con base al nombre/valor del dropdown
    }

    public void selectFromDropdownByIndex(String locator, int index){
        Select dropdown= new Select(Find(locator)); //Instancia clase tipo dropdown
        dropdown.selectByIndex(index); //posicion del valor a elegir
    }


    public int dropdownSize(String locator){
        return  new Select(Find(locator)).getOptions().size();
    }

    public List<String> getDropdownValues(String locator){
        List<WebElement> elements = driver.findElements(By.xpath(locator));
        return elements.stream().map(t->t.getText()).toList();
    }


    public String getButtonName(String locator){
         return Find(locator).getText().trim();

    }


    public void selectNthElement(String locator, int index){
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(d -> !d.findElements(By.xpath(locator)).isEmpty());
        List<WebElement> results= driver.findElements(By.xpath(locator));
        results.get(index).click();
    }


//    public void dragNDrop(String locator,String locator2){
//        WebElement element=Find(locator);
//        WebElement element2=Find(locator2);
//        action.
//
//    }



}
