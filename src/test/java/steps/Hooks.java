package steps;

import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import pages.BasePage;

public class Hooks extends BasePage {
    @After
    public void tearDown(Scenario scenario){
        if (scenario.isFailed()){
            scenario.log("Scenario failed. Please refer to the img attached");
            final byte[] screenshot= ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot,"image/jpeg", "error");
        }
    }
}
