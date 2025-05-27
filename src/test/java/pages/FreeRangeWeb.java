package pages;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FreeRangeWeb {
    private WebDriver driver;

    @BeforeMethod
    public void setUp(){
        //Inicializa el webdriver para chrome
        WebDriverManager.chromedriver().setup();
        driver= new ChromeDriver();
    }

    @Test
    public void navegarAWeb(){
        //Navega a la pagina web
        driver.get("https://www.freerangetesters.com");
    }

    @AfterMethod
    public void tearDown(){
        if(driver!=null){
            driver.quit();
        }
    }
}
