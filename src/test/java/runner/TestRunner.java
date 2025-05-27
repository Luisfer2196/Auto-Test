package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.AfterClass;
import org.junit.runner.RunWith;
import pages.BasePage;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/features", //Directorio de nuestros archivos .feature
        glue = "steps", //Paquete donde tenemos nuestras clases defiiendo los steps escritos en el feature file
        plugin = {"pretty","html:target/cucumber-reports"}, //"json:build/reports/cucumber.json" el que me dijo chatgpt
        tags = "@Amazon"

)

public class TestRunner {
    @AfterClass
    public static void closeDriver(){
        BasePage.closeBrowser();
    }

}
